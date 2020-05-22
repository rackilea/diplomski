interface ByteArray2D 
{
    int getNumRows();
    int getNumColumns();
    byte get(int r, int c);
    void set(int r, int c, byte b);
}