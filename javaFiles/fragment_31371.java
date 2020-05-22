import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestEditorPane {

    public static void main(String[] args) {
        new TestEditorPane();
    }

    public TestEditorPane() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JEditorPane htmlPane = new JEditorPane();
                String description = "<html><body>Hello<table border=1><tr><td><img alt='Bad' src='http://fc07.deviantart.net/fs70/i/2012/084/c/0/angry_wet_ponies_are_angry____by_tabby444-d4tyfsc.png'/></tr></td></table></body></html>";
                htmlPane.setContentType("text/html");
                htmlPane.setText(description);
                System.out.println(htmlPane.getText());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(htmlPane));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}