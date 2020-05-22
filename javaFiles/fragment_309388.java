import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Main
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(
            new Runnable() 
            {
                public void run() 
                {
                    createAndShowGUI();
                }
            });
    }

    private static void createAndShowGUI()
    {
        final TestFrame frame;

        frame = new TestFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(new Rectangle(10, 10, 300, 300));
        frame.init();
        frame.setVisible(true);
    }
}

class TestFrame
    extends    JFrame
    implements ActionListener
{
    private final JButton aBtn;
    private final JButton bBtn;

    public TestFrame()
    {
        super("Test");

        aBtn = new JButton("A");
        bBtn = new JButton("B");
    }

    public void init()
    {
        setLayout(new FlowLayout());
        add(aBtn);
        add(bBtn);

        // the class, since it implements ActionListener
        aBtn.addActionListener(this);
        bBtn.addActionListener(this);

        // outer classes
        aBtn.addActionListener(new OuterAListener(this));
        bBtn.addActionListener(new OuterBListener(this));

        // inner class
        aBtn.addActionListener(new InnerAListener());
        bBtn.addActionListener(new InnerBListener());

        // anonymous classes
        aBtn.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(final ActionEvent e)
                {
                    System.out.println ("Hi from Anonymous A");
                }
            });

        bBtn.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(final ActionEvent e)
                {
                    System.out.println ("Hi from Anonymous B");
                }
            });
    }

    public void actionPerformed(final ActionEvent evt)
    {
        final Object source;

        source = evt.getSource();

        if(source == aBtn)
        {
            System.out.println ("Hi from this A");
        }
        else if (source == bBtn)
        {
            System.out.println ("Hi from this B");
        }
        else
        {
            // ???
        }
    }

    private class InnerAListener
        implements ActionListener
    {
        public void actionPerformed(final ActionEvent e)
        {
            System.out.println ("Hi from Inner A");
        }
    }

    private class InnerBListener
        implements ActionListener
    {
        public void actionPerformed(final ActionEvent e)
        {
            System.out.println ("Hi from Inner B");
        }
    }
}

class OuterAListener
    implements ActionListener
{
    private final TestFrame frame;

    public OuterAListener(final TestFrame f)
    {
        frame = f;
    }

    public void actionPerformed(final ActionEvent e)
    {
        System.out.println ("Hi from Outer A");
    }
}

class OuterBListener
    implements ActionListener
{
    private final TestFrame frame;

    public OuterBListener(final TestFrame f)
    {
        frame = f;
    }

    public void actionPerformed(final ActionEvent e)
    {
        System.out.println ("Hi from Outer B");
    }
}