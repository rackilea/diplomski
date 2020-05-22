public class Draw {
    public static void main(String[] args) throws ColorException {new Draw();}

    /** Application constructor:  create an instance of our GUI class */
    public Draw() throws ColorException { window = new DrawGUI(this); }

    protected DrawGUI window;  // <- is now a DrawGUI

    public int getWidth(){
        return window.getPanelWidth();
    }

}

class DrawGUI extends JFrame {
    JPanel drawPanel;
    ...

    public DrawGUI(Draw application) throws ColorException {
        super("Draw");        // Create the window
        app = application;

        drawPanel = new JPanel();
    }

    public int getPanelWidth() {  // <- added method to get panel width
        return drawPanel.getWidth();
    }
}