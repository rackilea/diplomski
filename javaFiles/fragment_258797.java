import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class RemoveDemo {

    static class RemoveAction extends AbstractAction{
        private Container container;

        public RemoveAction(Container container){
            super("Remove me");
            this.container = container;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            container.remove((Component) e.getSource());
            container.validate();
            container.repaint();    
        }
    }

    private static void createAndShowGUI() {
        final JFrame frame = new JFrame("Demo");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RemoveAction action = new RemoveAction(frame);
        frame.add(new JButton(action));
        frame.add(new JButton(action));

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}