/**
 * The custom component
 */
public class Block extends JComponent {

    private final static String ID = "BlockUI";

    public Block(Color color) {
        // configure
        setBackground(color);
        // install ui
        updateUI();
    }


    @Override
    public void updateUI() {
        // ask the ui manager for an appropriate ui and set it
        setUI(UIManager.getUI(this));
    }

    /**
     * Implemented to return a unique component class identifier
     */
    @Override
    public String getUIClassID() {
        return ID;
    }

}

/**
 * For each supported LAF, a laf-specific implementation
 */
public class BasicBlockUI extends ComponentUI {

    public static ComponentUI createUI(JComponent c) {
        return new BasicBlockUI();
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        g.setColor(c.getBackground());
        g.fillRect(10,10, c.getWidth()- 20, c.getHeight()-20);
    }

}

// usage

//let the ui manager know of our component
// the value must be the fully qualified classname
UIManager.put("BlockUI", "org.jdesktop.swingx.plaf.BasicBlockUI");

JXFrame frame = new JXFrame("custom box", true);
Block block = new Block(Color.RED);
frame.add(block);
frame.setSize(200, 200);
frame.setVisible(true);