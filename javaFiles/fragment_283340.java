import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.synth.*;

public class SynthSliderTest {

    private JFrame f = new JFrame();

    public SynthSliderTest() {
        try {
            SynthLookAndFeel laf = new SynthLookAndFeel();
            laf.load(SynthSliderTest.class.getResourceAsStream("yourPathTo/demo.xml"), SynthSliderTest.class);
            UIManager.setLookAndFeel(laf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().add(makeUI());
        f.setSize(320, 240);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public JComponent makeUI() {
        JSlider slider = new JSlider(0, 100);
        JPanel p = new JPanel();
        p.add(slider);
        return p;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                SynthSliderTest synthSliderTest = new SynthSliderTest();
            }
        });
    }
}