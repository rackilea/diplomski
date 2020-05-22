import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {

    public Test() {
        createAndShowGui();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }

    private void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DeleteStudent());
        frame.pack();
        frame.setVisible(true);
    }
}

class DeleteStudent extends JPanel {

    public JPanel search = new JPanel() {//for testing
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    };
    private final JButton deleteButton = new JButton("Delete from database");
    private GridBagConstraints cons = new GridBagConstraints();
    private final GridBagLayout gridBag = new GridBagLayout();

    public DeleteStudent() {
        super();
        setLayout(gridBag);

        addComponents();
        addComponents(); //Method fails when run more than once!
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }

    public void addComponents() {
        removeAll();//must call this before resetting Layout and adding new components

        cons.gridy = 1;
        cons.insets = new Insets(50, 0, 0, 0);
        gridBag.setConstraints(deleteButton, cons);

        add(search);
        add(deleteButton);
        update();
    }

    private void update() {
        revalidate();
        repaint();
    }
}