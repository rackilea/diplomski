static double screenWidth= screen.getWidth(); 
static double screenHeight=screen.getHeight(); 
int pixelPerInch=java.awt.Toolkit.getDefaultToolkit().getScreenResolution(); 
static double scalingFactorheight=(screenWidth/screenHeight)/1.25;

public static int widthconverter(double x){
    int width = 0;
    width=(int) ((x/1280.0)*screenWidth);
    return width;
}

public static int heightconverter(double x){
    int height = 0;
    height=(int) ((x/1024.0)*screenHeight*scalingFactorheight);
    return height;
}