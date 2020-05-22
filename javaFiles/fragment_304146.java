import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SimpleLayout {

    public static void main(String[] args) {
        new SimpleLayout();
    }

    public SimpleLayout() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JMenuBar mb = new JMenuBar();
                mb.add(new JMenu("File"));
                mb.add(new JMenu("Add"));
                mb.add(new JMenu("Edit"));
                mb.add(new JMenu("Analize"));
                mb.add(new JMenu("About"));

                JFrame frame = new JFrame("Testing");
                frame.setJMenuBar(mb);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new BasePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class BasePane extends JPanel {

        private JTextArea species;
        private JTextArea locations;
        private JTextArea travelPaths;

        private JDesktopPane desktopPane;

        public BasePane() {                
            setLayout(new BorderLayout());

            desktopPane = new JDesktopPane();

            species = new JTextArea("Species");
            locations = new JTextArea("Locations");
            travelPaths = new JTextArea("TravelPaths");

            JPanel controls = new JPanel(new GridLayout(3, 0));
            controls.add(new JScrollPane(species));
            controls.add(new JScrollPane(locations));
            controls.add(new JScrollPane(travelPaths));

            add(controls, BorderLayout.WEST);
            add(desktopPane);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }            
    }        
}