public class RotateImages {

    public RotateImages(){
        MarvinImage image = MarvinImageIO.loadImage("./res/auto.jpg");
        MarvinImageIO.saveImage(rotate90(image), "./res/auto_90.jpg");
        MarvinImageIO.saveImage(rotate180(image), "./res/auto_180.jpg");
        MarvinImageIO.saveImage(rotate270(image), "./res/auto_270.jpg");
    }

    private MarvinImage rotate90(MarvinImage image){
        MarvinImage imageOut = new MarvinImage(image.getHeight(), image.getWidth());
        for(int y=0; y<image.getHeight(); y++){
            for(int x=0; x<image.getWidth(); x++){
                int newX = y;
                int newY = (image.getWidth()-1)-x;
                imageOut.setIntColor(newX, newY, image.getIntColor(x, y));
            }
        }
        return imageOut;
    }

    private MarvinImage rotate180(MarvinImage image){
        MarvinImage imageOut = new MarvinImage(image.getWidth(), image.getHeight());
        for(int y=0; y<image.getHeight(); y++){
            for(int x=0; x<image.getWidth(); x++){
                int newX = (image.getWidth()-1)-x;
                int newY = (image.getHeight()-1)-y;
                imageOut.setIntColor(newX, newY, image.getIntColor(x, y));
            }
        }
        return imageOut;
    }

    private MarvinImage rotate270(MarvinImage image){
        MarvinImage imageOut = new MarvinImage(image.getHeight(), image.getWidth());
        for(int y=0; y<image.getHeight(); y++){
            for(int x=0; x<image.getWidth(); x++){
                int newX = (image.getHeight()-1)-y;
                int newY = x;
                imageOut.setIntColor(newX, newY, image.getIntColor(x, y));
            }
        }
        return imageOut;
    }

    public static void main(String[] args) {    new RotateImages(); }
}