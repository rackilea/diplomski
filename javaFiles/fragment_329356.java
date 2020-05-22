import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;

class Success extends JPanel implements ActionListener{

    private final Timer timer = new Timer(20, this);  // Create a timer that will go off every 20 ms
    Line2D horizontalLine; // Declare your variables here, but don't initialize them
    Line2D verticalLine;   // That way, they can be accessed later in actionPerformed and repaint

    // You might want to try frame.setResizable(false) if you want your frame
    // and your panel to stay the same size.
    private final Dimension prefPanelSize = new Dimension(450, 450);

    public Success(){
        super();    // Call the constructor of JPanel, the class this subclasses.
        JButton button =new JButton("press");
        this.add(button);
        this.setSize(prefPanelSize);
        horizontalLine = new Line2D.Float(0, 40, prefPanelSize.width, 40);
        verticalLine = new Line2D.Float(prefPanelSize.width / 2, 0,
                prefPanelSize.width / 2, prefPanelSize.height);

        timer.start();  // Start the timer
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // fixes the immediate problem.
        Graphics2D g2 = (Graphics2D) g;

        g2.draw(horizontalLine);
        g2.draw(verticalLine);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return prefPanelSize;
    }

    public static void main(String []args){
        Success s = new Success();
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(new Dimension(450, 450));
        frame.add(s);
    }

    // This method is called ever 20 ms because of the timer.
    @Override
    public void actionPerformed(ActionEvent e) {
        int currWidth = getWidth();
        int currHeight = getHeight();

        horizontalLine.setLine(0, 40, currWidth, 40);
        verticalLine.setLine(currWidth / 2, 0, currWidth / 2, currHeight);
    }
}