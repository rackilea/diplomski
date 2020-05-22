import java.awt.event.ActionEvent;
import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;

public class AppletTest extends JApplet
        implements ActionListener
{
    private static final long serialVersionUID = 1L;
    private Frame findParentFrame()
    {
        Container c = this;
        while(c != null)
        {
            if(c instanceof Frame)
                return (Frame) c;

            c = c.getParent();
        }
        return (Frame) null;
    }
    private void createGUI()
    {
        Container content = getContentPane();
        content.setBackground(Color.white);
        content.setLayout(new FlowLayout());
        content.add(new JButton("Button 1"));
        content.add(new JButton("Button 2"));
        content.add(new JButton("Button 3"));
        JDialog d = new JDialog(findParentFrame());
        d.setModal(true);
        d.setVisible(true);
    }

    public void init()
    {
        try
        {
            SwingUtilities.invokeAndWait(new Runnable()
            {
                public void run()
                {
                    createGUI();
                }
            });
        }catch(Exception e)
        {
            System.err.println("createGUI didn't successfully complete");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
    }
}