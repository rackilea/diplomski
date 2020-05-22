import org.apache.commons.math3.complex.Complex;

public class MCLT
{
    public static void main(String args[])
    {
        Complex[] x = new Complex[16];

        for (int i = 1; i <= 16; ++i)
            x[(i - 1)] = new Complex((double)i, 0.0d);

        Complex[] result = fmclt(x);

        for (int i = 0; i < result.length; ++i)
            System.out.println(result[i]);
    }

    public static Complex[] fmclt(Complex[] x)
    {
        int L = x.length;
        int M = L / 2;

        double z = Math.sqrt(1.0d / (2.0d * M));

        Complex[] F = fft(x);
        Complex[] U = new Complex[F.length];

        for (int i = 0; i < F.length; ++i)
            U[i] = F[i].multiply(z);

        double[] k = new double[(M + 1)];

        for (int i = 0; i <= M; ++i)
            k[i] = (double)i;

        Complex[] c = new Complex[(M + 1)];

        for (int i = 0; i <= M; ++i)
            c[i] = W(8.0d, ((2.0d * k[i]) + 1.0d)).multiply(W((4.0d * M), k[i]));

        Complex[][] V = new Complex[(M + 1)][];

        for (int i = 0; i <= M; ++i)
        {
            V[i] = new Complex[(M + 1)];

            for (int j = 0; j <= M; ++j)
                V[i][j] = c[i].multiply(U[j]);
        }

        Complex[] V1 = new Complex[M];

        for (int i = 0; i < M; ++i)
            V1[i] = V[i][0];

        Complex[] V2 = new Complex[M];

        for (int i = 1; i <= M; ++i)
            V2[(i - 1)] = V[i][0];

        Complex b = new Complex(0.0d, 1.0d);
        Complex[] result = new Complex[M];

        for (int i = 0; i < M; ++i)
            result[i] = b.multiply(V1[i]).add(V2[i]); 

        return result;
    }

    public static Complex[] fft(Complex[] x)
    {
        int n = x.length;

        if (n == 1)
            return new Complex[] { x[0] };

        if ((n % 2) != 0)
            throw new IllegalArgumentException("Invalid length.");

        int nh = n / 2;

        Complex[] even = new Complex[nh];

        for (int i = 0; i < nh; ++i)
            even[i] = x[(2 * i)];

        Complex[] q = fft(even);

        Complex[] odd  = even;

        for (int i = 0; i < nh; ++i)
            odd[i] = x[((2 * i) + 1)];

        Complex[] r = fft(odd);

        Complex[] y = new Complex[n];

        for (int i = 0; i < nh; ++i)
        {
            double kth = -2.0d * i * (Math.PI / n);
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));

            y[i] = q[i].add(wk.multiply(r[i]));
            y[(i + nh)] = q[i].subtract(wk.multiply(r[i]));
        }

        return y;
    }

    public static Complex W(double M, double r)
    {
        Complex j = (new Complex(0.0d, 1.0d)).multiply(-1.0d);
        double z = 2.0d * Math.PI * (r / M);

        return j.multiply(z).exp();
    }
}