import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JEditorPaneTest extends JPanel {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                final JFrame frame = new JFrame();
                JEditorPane editor = new JEditorPane();

                frame.getContentPane().add(editor);

                editor.setContentType("text/html");
                URL url = null;
                try {
                    url = new URL("http://www.google.co.za");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(JEditorPaneTest.class.getName()).log(Level.SEVERE, null, ex);
                }

                BufferedReader in = null;
                try {
                    in = new BufferedReader(new InputStreamReader(url.openStream()));
                } catch (IOException ex) {
                    Logger.getLogger(JEditorPaneTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                String inputLine;
                StringBuffer response = new StringBuffer();
                try {
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine).append("\n");
                    }
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(JEditorPaneTest.class.getName()).log(Level.SEVERE, null, ex);
                }


                // editor.setText("<html><body>Hello, world</body></html>");
                editor.setText(response.toString());
                editor.setEditable(false);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}