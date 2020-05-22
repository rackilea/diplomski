import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;


public class Dialog extends JDialog
{
    private JButton done;

    public Dialog()
    {
        done = new JButton("Done");

        this.add(done);

        this.setSize(new Dimension(400,200));
    }

    public void setDialogLocation(int x, int y)
    {
        this.setLocation(x, y);
    }

}