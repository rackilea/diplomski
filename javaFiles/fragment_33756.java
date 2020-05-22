public class TestGUI extends JFrame {

Panel panel;
Point mouseLocation = new Point();
Dimension borderSize = new Dimension();
ScheduledExecutorService ex = Executors.newSingleThreadScheduledExecutor();
public TestGUI()
{
    setSize(1000, 600);
    setLocationRelativeTo(null);
    panel = new Panel();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(panel);
    setVisible(true);
    borderSize.setSize(getSize().width - getContentPane().getSize().width, getSize().height - getContentPane().getSize().height);
    ex.schedule(new UpdatingService(), 10, TimeUnit.MILLISECONDS);
}

class Panel extends JPanel
{
    public Panel()
    {
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawString("(" + mouseLocation.x + "," + mouseLocation.y + ")", 100, 100);
    }
}

private void checkMouse()
{
    mouseLocation.x = MouseInfo.getPointerInfo().getLocation().x - this.getLocationOnScreen().x - borderSize.width;
    mouseLocation.y = MouseInfo.getPointerInfo().getLocation().y - this.getLocationOnScreen().y - borderSize.height;
    repaint();
}

class UpdatingService implements Runnable
{
    @Override
    public void run()
    {
        checkMouse();
        ex.schedule(new UpdatingService(), 10, TimeUnit.MILLISECONDS);
    }
}

public static void main(String[] args) {
    new TestGUI();
}
}