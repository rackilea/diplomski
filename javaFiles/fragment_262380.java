import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame implements Progressable {

    private JProgressBar bar;
    public Communicator diplayFacade;
    private boolean inProgress;

    public MainFrame() {
        diplayFacade = new Communicator(this);
        bar = new JProgressBar();
        setLayout(new GridBagLayout());
        add(bar);
        addPropertyChangeListener("inProgress", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (isInProgress()) {
                    bar.setIndeterminate(true);
                } else {
                    bar.setIndeterminate(false);
                }
            }
        });
    }

    @Override
    public void setInProgress(boolean value) {
        if (inProgress != value) {

            inProgress = value;
            firePropertyChange("inProgress", !inProgress, inProgress);

        }
    }

    @Override
    public boolean isInProgress() {
        return inProgress;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new MainFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}