import java.util.Random;

/**
 * MatrixTest
 * @author Michael
 * @since 2/20/11
 */
public class MatrixTest
{
    private static final int DEFAULT_SIZE = 3;
    private double [] x;
    private double [] y;
    private int n;

    public static void main(String[] args)
    {
        MatrixTest m = new MatrixTest();
        System.out.println(m);
    }

    public MatrixTest()
    {
        this(DEFAULT_SIZE);
    }

    public MatrixTest(int n)
    {
        this.init(n);
    }

    public void init(int n)
    {
        Random random = new Random(System.currentTimeMillis());

        this.x = new double[n];
        this.y = new double[n];
        this.n = n;
        for (int i = 0; i < this.n; i++)
        {
            x[i] = random.nextDouble();
            y[i] = random.nextDouble();
        }
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder();
        sb.append("MatrixTest");
        sb.append("{x=").append(x == null ? "null" : "");
        for (int i = 0; x != null && i < x.length; ++i)
        {
            sb.append(i == 0 ? "" : ", ").append(x[i]);
        }
        sb.append(", y=").append(y == null ? "null" : "");
        for (int i = 0; y != null && i < y.length; ++i)
        {
            sb.append(i == 0 ? "" : ", ").append(y[i]);
        }
        sb.append(", n=").append(n);
        sb.append('}');
        return sb.toString();
    }
}