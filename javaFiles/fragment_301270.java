Pixmap pixmap = new Pixmap( colors.length, colors[0].length, Format.RGBA8888 );
for (int i = 0; i < colors.length; i++)
{
    for (int i = 0; i < colors.length; i++)
    {

        pixmap.setColor( 0, 1, 0, 0.75f ); //Set to color r,g,b,a
        pixmap.drawPixel(i,j); //Draw the pixel
    }
}
Texture pixmaptex = new Texture(pixmap); //Create new texture from the Pixmap
pixmap.dispose();