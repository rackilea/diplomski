class SimpleSample
{

    static
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void printArr( byte[][] arr )
    {
        for ( int y=0; y<arr[0].length; ++y )
        {
            for ( int x=0; x<arr.length; ++x )
                System.out.print( arr[x][y] + ", " );
            System.out.println("");
        }

    }

    public static void main(String[] args)
    {
        Mat mat = new Mat(5, 10, CvType.CV_8UC1, new Scalar(255));
        mat.row(1).setTo(new Scalar(0));
        System.out.println( mat.dump() );
        byte[][] arr = new byte[mat.cols()][mat.rows()];

        byte[] tmp = new byte[1];
        for ( int i=0; i<mat.rows(); ++i )
        {
            for ( int j=0; j<mat.cols(); ++j )
            {
                mat.get(i, j, tmp);
                arr[j][i] = tmp[0];
            }
        }
        printArr(arr);
    }

}