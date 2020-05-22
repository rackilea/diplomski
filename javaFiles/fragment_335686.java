private Image img;
private Pixel pixel;
private Image newimg;
private Pixel newpixel;

public advancedFilters(Image img)
{
    this.img = img;
}

public Image Mirror(){
    newimg = new Image(img.getWidth(), img.getHeight(), "newimage");
    for (int j=0; j<img.getHeight(); j++) {
        for (int i=0; i<img.getWidth(); i++) {
            Pixel oldPixel = img.getPixel(i,j);
            int oldPixelVal = oldPixel.getValue();
            Pixel mirrorPixel = newimg.getPixel((newimg.getWidth()-i-1), j);
            mirrorPixel.setValue(curtone);

        }
    }
    return newimg;
}