class Tile 
    implements Rectangle 
{
    private int height;
    private int width;

     @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setHeight(int h) {
        height = h;
    }

    @Override
    public void setWidth(int w) { 
        width = w;  
    }
}