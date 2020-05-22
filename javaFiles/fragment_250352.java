public class Ball {
    int screenWidth;
    int screenHeight;

    public Ball(){
        this.screenWidth = Constants.getInstance().getWidth();
        this.screenHeight= Constants.getInstance().getHeight();
    }
}