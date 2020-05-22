import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.concurrent.*;
import javax.swing.*;

public class PolygonBuilder extends JFrame{

    final static int WIDTH = 640;
    final static int HEIGHT = 320;
    public static int xPointPos, yPointPos;
    public static void main(String[] args) {
        new PolygonBuilder();
    }
    public PolygonBuilder() {
        setTitle("Build a Polygon");
        // let's be nice to the user..
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this is almost certainly not the correct size, 
        // but in itself could deserve a question
        this.setSize(WIDTH,HEIGHT);
        setResizable(false);
        JLabel placeholder = new JLabel("Label!");
        BuilderDrawingPanel BuilderPanel = new BuilderDrawingPanel();
        this.add(BuilderPanel, BorderLayout.CENTER);

        JToggleButton DotOnOff = new JToggleButton("Dot");
        DotOnOff.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                if(DotOnOff.isSelected()) {
                    System.out.println("ON");
                } else {
                    System.out.println("OFF");
                }
            }
        });

        DotOnOff.setBounds(100, 100, 90, 35);

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
        executor.scheduleAtFixedRate(new RepaintTheBoard(this), 0L, 20L, TimeUnit.MILLISECONDS);

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent arg0) {}

            @Override
            public void mouseMoved(MouseEvent arg0) {
                Point p = MouseInfo.getPointerInfo().getLocation();
                xPointPos = (int) p.getX();
                yPointPos = (int) p.getY();
                System.out.println(xPointPos+","+yPointPos);
            }
        });

        // create a new panel for these buttons..
        //this.add(DotOnOff);
        //this.add(placeholder);
        JPanel buttonPanel = new JPanel(); // default flow layout
        buttonPanel.add(DotOnOff);
        buttonPanel.add(placeholder);
        // now add that panel above the builder panel
        this.add(buttonPanel, BorderLayout.PAGE_START);
        setVisible(true);
    }
}
class RepaintTheBoard implements Runnable {
    PolygonBuilder theBuilder;

    public RepaintTheBoard(PolygonBuilder theBuilder) {
        this.theBuilder = theBuilder;
    }

    @Override
    public void run() {
        theBuilder.repaint();
    }
}

@SuppressWarnings("serial")
class BuilderDrawingPanel extends JComponent{
    static Graphics2D graphicSettings;
    static Shape drawLine;
    public BuilderDrawingPanel() {
        //stuff to draw at start
        System.out.println("Drawing..");
        drawLine =  new Line2D.Float(480,480,0,0);
    }
    @Override
    public void paint(Graphics g) {

        graphicSettings = (Graphics2D)g;
        System.out.println("Drawing..");
        graphicSettings.setColor(Color.RED);
        graphicSettings.fillRect(0, 0, getWidth(), getHeight());
        graphicSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphicSettings.setPaint(Color.BLUE);
        graphicSettings.draw(drawLine);
    }
}