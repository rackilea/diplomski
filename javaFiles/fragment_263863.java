public class GameMain extends Applet implements KeyListener {

    //...
    private Droid droid;
    //...

    @Override
    public void init() {
        //...
        droid = new Droid();
        //...
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(character, droid.getPositionX() - 61, droid.getPositionY()- 63, this);
    }