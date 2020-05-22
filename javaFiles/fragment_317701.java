import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;


public class Main extends JFrame {

    private static final long serialVersionUID = 1L;

    private Internal internalFrame;

    public Main() throws HeadlessException {
        super("Internal Frame Test");

        setBounds(10, 10, 600, 400);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());

        add(createDesktop(), BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                internalFrame.setVisible(true);
            }
        });

        setVisible(true);
    }

    private Component createDesktop() {
        JDesktopPane d = new JDesktopPane();

        internalFrame = new Internal("first");
        d.add(internalFrame);

        return d;
    }

    public static class Internal extends JInternalFrame {

        private static final long serialVersionUID = 1L;

        public Internal(String title) {
            super(title);
            setBounds(10, 10, 300, 100);
        }
    }

    public static void main(String[] a) {
        new Main();
    }
}