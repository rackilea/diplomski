import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JSlider slider;
        private int vertices = 3;
        private List<JTextField[]> fields = new ArrayList<>(3);

        private JPanel right;

        public TestPane() {
            setLayout(new BorderLayout());
            right = new JPanel(new GridLayout(0, 2));
            add(new JScrollPane(right));

            slider = new JSlider();
            slider.addChangeListener(new SpinerListener());
            slider.setValue(vertices);

            add(slider, BorderLayout.NORTH);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        class SpinerListener implements ChangeListener {

            public void stateChanged(ChangeEvent arg0) {
                vertices = slider.getValue();

                if (vertices < fields.size()) {
                    List<JTextField[]> oldFields = fields.subList(vertices + 1, fields.size());
                    for (JTextField[] pairs : oldFields) {
                        for (JTextField field : pairs) {
                            right.remove(field);
                        }
                    }
                    fields.removeAll(oldFields);
                    right.revalidate();
                    right.repaint();
                } else if (vertices > fields.size()) {
                    int count = (vertices - fields.size());
                    System.out.println("Add " + count + " new fields");
                    for (int index = 0; index < count; index++) {
                        JTextField[] pairs = new JTextField[2];
                        pairs[0] = new JTextField(4);
                        pairs[1] = new JTextField(4);

                        for (JTextField field : pairs) {
                            right.add(field);
                        }

                        fields.add(pairs);
                    }
                    right.revalidate();
                    right.repaint();
                }
            }

        }
    }
}