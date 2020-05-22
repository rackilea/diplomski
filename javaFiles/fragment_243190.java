import java.awt.*;
import javax.swing.*;

class MirrorImageIcon extends ImageIcon
{
    public MirrorImageIcon(String filename)
    {
        super(filename);
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.translate(0, getIconHeight());
        g2.scale(1, -1);
        super.paintIcon(c, g2, x, y);
        g2.dispose();
    }

    private static void createAndShowUI()
    {
        ImageIcon io = new MirrorImageIcon("dukewavered.gif");
        JLabel label = new JLabel(io);

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}