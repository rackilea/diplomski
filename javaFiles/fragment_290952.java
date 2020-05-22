class Verts
{
    static {
        System.loadLibrary( "<i>libraryName</i>" );
    }

    private static Integer[] nativeVerts( int L, int W, int l, int w );
    public Integer[][] verts( int L, int W, int l, int w )
    {
        Integer[] tmp = nativeVerts( L, W, l, w );
        //  reshape tmp...
        return reshapedData;
    }
}