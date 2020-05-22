import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Demo {

    private Shape circle;
    private int width = 100;
    private int height = 100;

    private void initGUI(){

        final JPanel drawPane = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                circle = new Ellipse2D.Float(100, 20, width, height);
                Graphics2D graphics = (Graphics2D)g.create();
                graphics.draw(circle);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400,300);
            }
        };

        JSlider widthSlider = new JSlider(width, width * 2, width);
        widthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider)e.getSource();
                width = slider.getValue();
                drawPane.repaint();
            }
        });

        JSlider heightSlider = new JSlider(height, height * 2, height);
        heightSlider.setOrientation(JSlider.VERTICAL);
        heightSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider)e.getSource();
                height = slider.getValue();
                drawPane.repaint();
            }
        });

        JPanel content = new JPanel(new BorderLayout());
        content.add(widthSlider, BorderLayout.NORTH);
        content.add(drawPane, BorderLayout.CENTER);
        content.add(heightSlider, BorderLayout.WEST);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(content);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().initGUI();
            }
        });
    }

}