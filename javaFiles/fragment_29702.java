import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            DefaultComboBoxModel<Fruit> fruitModel = new DefaultComboBoxModel<>();
            fruitModel.addElement(new Fruit("Apple"));
            fruitModel.addElement(new Fruit("Banana"));
            fruitModel.addElement(new Fruit("Grapes"));
            fruitModel.addElement(new Fruit("Pears"));
            JComboBox cb = new JComboBox(fruitModel);
            cb.setEditable(true);
            add(cb);
            cb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int index = cb.getSelectedIndex();
                    Object value = cb.getSelectedItem();
                    if (!(value instanceof Fruit)) {
                        System.out.println(value + " is not a fruit");
                        cb.addItem(new Fruit(value.toString()));
                    } else {
                        System.out.println(value + " is a fruit");
                    }
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class Fruit {
        private String name;

        public Fruit(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return getName();
        }

    }

}