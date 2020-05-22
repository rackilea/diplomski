class Bitmap {
    private byte[] rawData;
    private int rows;
    private int cols;
    public int getPixel(int x, int y) {
        if (x < 0 || x >= cols || y < 0 || y >= rows) {
            throw new ...
        }
        int offset = 3*(rows*y + x);
        return (rawData[offset] << 16)
             | (rawData[offset+1] << 8)
             | rawData[offset+2];
    }
}