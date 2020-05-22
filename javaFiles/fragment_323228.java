public static Texture getTexture(){

    Pixmap pixmap;
    try {
        pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
    }catch (GdxRuntimeException e)
    {
        pixmap=new Pixmap(1,1, Pixmap.Format.RGB565);
    }
    pixmap.setColor(Color.WHITE);
    pixmap.drawRectangle(0,0,1,1);

    return new Texture(pixmap);
}