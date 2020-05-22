public class t1
{
    public static void main(String[] args) throws Exception
    {
    int[] a = new int[1];
    double[] b = new double[1];

    int[] array1 = (int[]) myTest(a,b)[0];
    double[] array2 = (double[]) myTest(a,b)[1];
    System.err.println(array1);
    System.err.println(array2);
    }

    static Object[] myTest(int[] a, double[] b){
    return new Object[]{a,b};
    }
}