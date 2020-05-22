import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

public class TestRotate
{
    public static void main(String args[])
    {
        JFrame frame = new JFrame("Test Rotate");

        JPanel gui = new JPanel(new BorderLayout());

        final HousePanel housePanel = new HousePanel();
        gui.add(housePanel, BorderLayout.CENTER);

        final JCheckBox transform = new JCheckBox("Transform");
        transform.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                housePanel.setTransform(transform.isSelected());
                housePanel.repaint();
            }
        });
        gui.add(transform, BorderLayout.NORTH);

        frame.add( gui );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        gui.setPreferredSize( new Dimension(300, 200) );
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible( true );
    }
}

class HousePanel extends JPanel {

    public int[] HouseX = {
        100,105,110,105,100,95
    };

    public int[] HouseY = {
        100,
        100,
        (int)(100+(5*(Math.sqrt(3))/2)),
        (int)(100+(5*(Math.sqrt(3)))),
        (int)(100+(5*(Math.sqrt(3)))),
        (int)(100+(5*(Math.sqrt(3))/2))
    };

    boolean transform = false;

    public void setTransform(boolean transform) {
        this.transform = transform;
    }

    public void paintComponent( Graphics g )
    {
        final Graphics2D g2 = (Graphics2D) g;
        g2.clearRect( 0, 0, this.getWidth(), this.getHeight() );
        g2.setColor( Color.BLACK );

        if (transform) {
            AffineTransform transform = new AffineTransform();

            transform.scale( -1.0, 1.0 );
            g2.setTransform( transform );
        }
        g2.drawPolygon(HouseX, HouseY, 6);
    }

}