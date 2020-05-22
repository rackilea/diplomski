import java.util.Locale;

interface Consumer<T>
{
    void accept(T t);
}

public class MatMulExplainer
{
    public static void main(String[] args)
    {
        test2x2_2x2();
        test3x2_2x4();
    }

    private static void test2x2_2x2()
    {
        double A[][] = {
            { 1, 2 },
            { 4, 3 },
        };
        double B[][] = {
            {  6,  9 },
            { -8, -5 },
        };
        double C[][] = explain(A, B, console());
    }

    private static void test3x2_2x4()
    {
        double A[][] = {
            { 1, 2 },
            { 4, 3 },
            { 5, 6 },
        };
        double B[][] = {
            {  6,  9, -3,  8},
            { -8, -5, -1,  7},
        };
        double C[][] = explain(A, B, console());
    }

    private static Consumer<String> console()
    {
        return new Consumer<String>()
        {
            @Override
            public void accept(String t)
            {
                System.out.println(t);
            }
        };
    }


    private static double[][] explain(
        double A[][], double B[][], Consumer<String> consumer)
    {
        consumer.accept("Multiply\n"+toString(A));
        consumer.accept("and\n"+toString(B));

        int rA = A.length;
        int cA = A[0].length;
        int cB = B[0].length;
        double C[][] = new double[rA][cB];
        for (int r=0; r<rA; r++)
        {
            for (int c=0; c<cB; c++)
            {
                float sum = 0;
                StringBuilder sb = new StringBuilder();
                sb.append("C"+r+","+c+" = ");
                for (int n=0; n<cA; n++)
                {
                    sb.append(toString(A[r][n])+" * "+toString(B[n][c]));
                    sum += A[r][n] * B[n][c];
                    if (n < cA - 1)
                    {
                        sb.append(" + ");
                    }
                }
                sb.append(" = "+toString(sum));
                consumer.accept(sb.toString());
                C[r][c] = sum;
            }
        }

        consumer.accept("Result:\n"+toString(C));
        return C;
    }

    private static String toString(double A[][])
    {
        StringBuilder sb = new StringBuilder();
        for (int r=0; r<A.length; r++)
        {
            for (int c=0; c<A[r].length; c++)
            {
                sb.append(toString(A[r][c])+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    private static String toString(double d)
    {
        final String format = "%6.2f";
        return String.format(Locale.ENGLISH, format, d);
    }

}