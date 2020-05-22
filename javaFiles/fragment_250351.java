public class Main extends JApplet {
    public int width = getSize().width;
    public int height = getSize().height;

    public void init(){
        Constants.getInstance().setWidth(width);
        Constants.getInstance().setHeight(height);
        Ball ball = new Ball();
    }
}