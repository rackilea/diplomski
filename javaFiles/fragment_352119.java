import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TransparentInternalFrame extends JInternalFrame implements ActionListener
{
    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;
    private float alpha = 0.0f;
    private Timer timer = new Timer(500, this);

    public TransparentInternalFrame()
    {
        super("Document #" + (++openFrameCount), true, true, true, true);
        setSize(300,300);
        setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
        setVisible( true );
    }

    @Override
    public void paint(Graphics g)
    {
        g.setColor( getDesktopPane().getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());

        Graphics2D g2 = (Graphics2D)g.create();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        super.paint(g2);
    }

    public void showFrame()
    {
        timer.start();
    }

    public void hideFrame()
    {
        alpha = 0.0f;
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        alpha += .05f;
        alpha = Math.min(1.0f, alpha);
        System.out.println(alpha);

        if (alpha >= 1.0f)
            timer.stop();

        repaint();
    }

    private static void createAndShowGUI()
    {
        JDesktopPane desktop = new JDesktopPane();
        desktop.setBackground( Color.YELLOW );

        TransparentInternalFrame tif = new TransparentInternalFrame();
        desktop.add( tif );
        tif.add(new JButton("Hello"), BorderLayout.PAGE_START);

        JButton show = new JButton( "Show Internal Frame" );
        show.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tif.showFrame();
            }
        });

        JButton hide = new JButton( "Hide Internal Frame" );
        hide.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tif.hideFrame();
            }
        });

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(show, BorderLayout.PAGE_START);
        frame.add(desktop);
        frame.add(hide, BorderLayout.PAGE_END);
        frame.setLocationByPlatform( true );
        frame.setSize(500, 500);
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}