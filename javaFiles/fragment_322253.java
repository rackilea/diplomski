public class ThresholdingFilter {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  METHODS  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /**
     * Methods that apply a Thresholding Effect on image
     * 
     * @param imageIn the input image
     * @param threshold Integer - value (0-255)  prefered value (threshold = 125)
     * @return
     */ 

    public static AndroidImage process(AndroidImage imageIn, int threshold) {

        // The Resulting image
        AndroidImage imageOut;

        // Initiate the Output image
        imageOut = new AndroidImage(imageIn.getImage());

        // Do Threshold process
        for(int y=0; y<imageIn.getHeight(); y++){
            for(int x=0; x<imageIn.getWidth(); x++){

                if(imageOut.getRComponent(x,y) < threshold){
                    imageOut.setPixelColor(x, y, 0,0,0);
                }
                else{
                    imageOut.setPixelColor(x, y, 255,255,255);
                }               
            }
        }   

        // Return final image
        return imageOut;
    }

}