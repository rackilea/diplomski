import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jdesktop.jxlayer.JXLayer;
import org.pbjar.jxlayer.demo.TransformUtils;
import org.pbjar.jxlayer.plaf.ext.transform.DefaultTransformModel;

public class TestJLayerZoom {

    public static void main(String[] args) {
        new TestJLayerZoom();
    }

    public TestJLayerZoom() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JXLayer<JComponent> layer;
        private DefaultTransformModel transformModel;
        private JPanel content;

        public TestPane() {

            content = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridy = 0;

            JLabel label = new JLabel("Hello");
            JTextField field = new JTextField("World", 20);

            content.add(label, gbc);
            content.add(field, gbc);

            gbc.gridy++;
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            final JSlider slider = new JSlider(50, 200);
            slider.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent e) {
                    int value = slider.getValue();
                    double scale = value / 100d;
                    transformModel.setScale(scale);
                }
            });
            content.add(slider, gbc);

            transformModel = new DefaultTransformModel();
            transformModel.setScaleToPreferredSize(true);

            Map<RenderingHints.Key, Object> hints = new HashMap<>();
            //hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //hints.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            //hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            layer = TransformUtils.createTransformJXLayer(content, transformModel, hints);
            setLayout(new BorderLayout());
            add(layer);


        }

    }

}