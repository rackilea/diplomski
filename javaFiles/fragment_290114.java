import java.awt.*;
import javax.swing.*;

class GuiForJFrame extends JFrame {
    private FlowLayout layout;
    private Container container;

    public GuiForJFrame() {
        super("Drawing Graphics");

        // Setting the Layout
        layout = new FlowLayout(FlowLayout.LEFT);
        container = getContentPane();
        setLayout(layout);
    }

    public static void main(String[] args) {
        // Creating the JFrame object
        GuiForJFrame jFrame = new GuiForJFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding Graphics to JFrame
        GuiForDrawingGraphics graphics = new GuiForDrawingGraphics();
        jFrame.add(graphics);
        //jFrame.setSize(500, 200);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}

class GuiForDrawingGraphics extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.setColor(Color.RED);
        g.fillRect(25, 25, 150, 50);

        g.setColor(new Color(156, 32, 111));
        g.fillRect(25, 80, 150, 50);

        g.setColor(Color.BLACK);
        g.drawString("Drawing Graphics in JAVA", 25, 150);

    }

    public Dimension getPreferredSize() {
        return new Dimension(300,200);
    }
}