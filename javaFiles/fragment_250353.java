public class Main extends JApplet {
    public int width = getSize().width;
    public int height = getSize().height;

    public void init(){
        Ball ball = new Ball(width, height);
    }
}