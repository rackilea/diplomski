import java.awt.Desktop;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class Test {

    public static void main(String[] argv) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JEditorPane jep = new JEditorPane();
                jep.setContentType("text/html");//set content as html
                jep.setText("Welcome to <a href='http://stackoverflow.com/'>StackOverflow</a>.");

                jep.setEditable(false);//so its not editable
                jep.setOpaque(false);//so we dont see whit background

                jep.addHyperlinkListener(new HyperlinkListener() {
                    @Override
                    public void hyperlinkUpdate(HyperlinkEvent hle) {
                        if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
                            System.out.println(hle.getURL());
                            Desktop desktop = Desktop.getDesktop();
                            try {
                                desktop.browse(hle.getURL().toURI());
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });


                JFrame f = new JFrame("HyperlinkListener");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.add(jep);
                f.pack();
                f.setVisible(true);
            }
        });
    }
}