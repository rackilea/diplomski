import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Main extends JFrame implements ComponentListener, ActionListener
{
    private JButton ok;
    private Dialog dialog;

    public Main()
    {
        ok = new JButton("OK");
        ok.addActionListener(this);

        dialog = new Dialog();

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(ok);

        getContentPane().add(panel,"South");

        this.addComponentListener(this);

        this.setVisible(true);
        this.setSize(new Dimension(200,200));
        this.validate();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[]args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Main();
        }
        catch(Exception e){}
    }

    public void actionPerformed(ActionEvent ae)
    {   
        dialog.setVisible(true);
    }

    @Override
    public void componentHidden(ComponentEvent arg0) {}

    @Override
    public void componentMoved(ComponentEvent arg0) 
    {
        int x = this.getX() + this.getWidth();
        int y = this.getY();

        dialog.setDialogLocation(x, y);
    }

    @Override
    public void componentResized(ComponentEvent arg0) {}

    @Override
    public void componentShown(ComponentEvent arg0) {}
}