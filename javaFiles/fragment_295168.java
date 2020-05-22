import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class NormalFrame extends JFrame
{
    private static final long serialVersionUID = 1L;

    public NormalFrame()
    {
        super("The title");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.add(new CustomPanel(this));

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new NormalFrame().setVisible(true);
            }
        });
    }
}

class CustomPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    private JFrame mainFrame;
    private JLabel lbl;
    private JTextField txt;
    private JButton btn;

    private ActionListener listener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            mainFrame.setTitle(txt.getText());
        }
    };

    public CustomPanel(JFrame mainFrame)
    {
        this.mainFrame = mainFrame;

        lbl = new JLabel("The new title: ");
        txt = new JTextField(10);
        btn = new JButton("Change Title");
        btn.addActionListener(listener);

        setLayout(new BorderLayout());
        add(lbl, BorderLayout.LINE_START);
        add(txt, BorderLayout.CENTER);
        add(btn, BorderLayout.LINE_END);
    }
}