import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jdesktop.swingx.prompt.PromptSupport;

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

                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                JFormattedTextField DOB = new JFormattedTextField(df);
                DOB.setColumns(10);

                PromptSupport.setPrompt("dd/MM/yyyy", DOB);
                PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, DOB);

                JFrame frame = new JFrame("Testing");
                frame.setLayout(new GridBagLayout());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(DOB);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}