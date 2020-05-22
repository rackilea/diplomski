public class AndroidImage {

     //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  ATTRIBUTES  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // Original bitmap image
    private Bitmap image;

    // Format of the image (jpg/png)
    private String formatName;

    /** Dimensions of image */

    // Width of the image
    private int width;

    // Height of the image
    private int height;

    // RGB Array Color
    protected int[] colorArray;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  METHODS  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  

    /**
     * Constructor
     * 
     * @param img the Bitmap from which we create our AndroidImage Object 
     */

    public AndroidImage(Bitmap img){        
        this.image =  img;
        this.formatName = "jpg";
        this.width = img.getWidth();
        this.height = img.getHeight();
        updateColorArray();
    }


    /**
     * Method to reset the image to a solid color
     * 
     * @param color - color to reset the entire image to
     */

    public void clearImage(int color){
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                image.setPixel(x, y, color);
            }
        }
    }


    /**
     * Method to set color array for image - called on initialization by constructor
     * 
     * 
     */

    private void updateColorArray(){
        colorArray = new int[width * height];
        image.getPixels(colorArray, 0, width, 0, 0, width, height);
        int r, g, b;
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                int index = y * width + x;
                r = (colorArray[index] >> 16) & 0xff;
                g = (colorArray[index] >> 8) & 0xff;
                b = colorArray[index] & 0xff;
                colorArray[index] = 0xff000000 | (r << 16) | (g << 8) | b;
            }
        }
    }


    /**
     * Method to set the color of a specific pixel
     * 
     * @param x
     * @param y
     * @param color
     */

    public void setPixelColor(int x, int y, int color){
        colorArray[((y*image.getWidth()+x))] = color;
        image.setPixel(x, y, color);
    }

    /**
     * Method to get the color of a specified pixel
     * 
     * @param x
     * @param y
     * @return color
     */

    public int getPixelColor(int x, int y){
        return colorArray[y*width+x];
    }

    /**
     * Method to set the color of a specified pixel from an RGB combination
     * 
     * @param x
     * @param y
     * @param c0
     * @param c1
     * @param c2
     */

    public void setPixelColor(int x, int y, int c0, int c1, int c2){
        colorArray[((y*image.getWidth()+x))] = (255 << 24) + (c0 << 16) + (c1 << 8) + c2;
        image.setPixel(x, y, colorArray[((y*image.getWidth()+x))]);
    }

    /**
     * Method to get the RED color of a specified pixel 
     *  
     * @param x
     * @param y
     * @return color of R component
     */

    public int getRComponent(int x, int y){
        return (getColorArray()[((y*width+x))]& 0x00FF0000) >>> 16;
    }


    /**
     * Method to get the GREEN color of a specified pixel
     *  
     * @param x
     * @param y
     * @return color of G component
     */

    public int getGComponent(int x, int y){
        return (getColorArray()[((y*width+x))]& 0x0000FF00) >>> 8;
    }


    /**
     * Method to get the BLUE color of a specified pixel
     *  
     * @param x
     * @param y
     * @return color of B component
     */

    public int getBComponent(int x, int y){
        return (getColorArray()[((y*width+x))] & 0x000000FF);
    }



    /**
     * Method to rotate an image by the specified number of degrees
     * 
     * @param rotateDegrees
     */

    public void rotate (int rotateDegrees){
        Matrix mtx = new Matrix();
        mtx.postRotate(rotateDegrees);
        image = Bitmap.createBitmap(image, 0, 0, width, height, mtx, true);
        width = image.getWidth();
        height = image.getHeight();
        updateColorArray();
    }

     // Setters and Getters

    /**
     * @return the image
     */

    public Bitmap getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */

    public void setImage(Bitmap image) {
        this.image = image;
    }

    /**
     * @return the formatName
     */

    public String getFormatName() {
        return formatName;
    }

    /**
     * @param formatName the formatName to set
     */

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }


    /**
     * @return the width
     */

    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */

    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */

    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the colorArray
     */

    public int[] getColorArray() {
        return colorArray;
    }

    /**
     * @param colorArray the colorArray to set
     */

    public void setColorArray(int[] colorArray) {
        this.colorArray = colorArray;
    }

}