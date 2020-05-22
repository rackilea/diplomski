class SimpleSample
{

    static
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void printArr( byte[][] arr )
    {
        for ( int y=0; y<arr.length; ++y )
        {
            for ( int x=0; x<arr[y].length; ++x )
                System.out.print( arr[y][x] + ", " ); // Was arr[x][y] in prev code.
            System.out.println("");
        }

    }

    public static void main(String[] args)
    {
        Mat mat = new Mat(5, 10, CvType.CV_8UC1, new Scalar(255));
        mat.row(1).setTo(new Scalar(0));
        System.out.println( mat.dump() );
        byte[][] arr = new byte[mat.rows()][mat.cols()];

        for ( int i=0; i<mat.rows(); ++i )
                mat.get(i, 0, arr[i]);
        printArr(arr);
    }
}