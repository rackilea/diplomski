static class Index {

    private int x=0; // nr of rows
    private int y=0; // nr of columns
    private int hashvalue = 0;

    public Index (final int x, final int y)
    {
        this.x=x;
        this.y=y;
        hashvalue=((x+"")+(y+"")).hashCode();
    }

    public boolean equals (final Object obj)
    {
        if (obj instanceof Index)
        {
            Index index = (Index) obj;
            return ((x==index.x) && (y==index.y));
        }
        else
            return false;
    }

    public int hashCode()
    {
        return hashvalue;
    }

}