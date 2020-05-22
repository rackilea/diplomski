import java.awt.*;
import javax.swing.*;

public class EditorPaneTest extends JFrame
{
    public EditorPaneTest()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);        

        JEditorPane editPane = new JEditorPane();
        JScrollPane scrollPane = new JScrollPane(editPane);     

        editPane.setContentType("text/html");

        editPane.setText("<html><p style = \"text-align:center;\">Hello there, How you doing ?<img src = " + 
                                            "\"http://s018.radikal.ru/i504/1202/03/c01a2e35713f.gif" + 
                                                "\" alt = \"pic\" width = \"15\" height = \"15\" />I guess all is good!!" +
                                                        "<br />I hope this is what you wanted!! " + 
                                                                    "<img src =  \"http://s018.radikal.ru/i504/1202/03/c01a2e35713f.gif" + 
                                                "\" alt = \"pic\" width = \"15\" height = \"15\" /> Hope this works for you :-)</p></html>\n");

        add(scrollPane, BorderLayout.CENTER);
        setSize(400, 300);
        setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new EditorPaneTest();
            }
        });
    }
}