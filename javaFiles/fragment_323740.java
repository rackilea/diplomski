import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

class MainFrame extends JFrame implements ActionListener
{
    private JButton button;
    private JTextArea tArea;
    private InputBoard inBoard;
    public void prepareAndShowGUI()
    {
        setTitle("Main Frame");
        tArea = new JTextArea(10,30);
        button = new JButton("Click Me");
        inBoard = new InputBoard(this);
        inBoard.prepareGUI();
        JScrollPane tFieldPane = new JScrollPane(tArea);
        tArea.setLineWrap(true);
        tArea.setWrapStyleWord(true);
        tArea.setEditable(false);
        button.addActionListener(this);
        getContentPane().add(tFieldPane);
        getContentPane().add(button,BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        button.requestFocus();
    }
    @Override
    public void actionPerformed(ActionEvent evt)
    {
        if (!inBoard.isVisible())
        {
            inBoard.setVisible(true);
        }
        inBoard.toFront();
    }
    public void setText(final String s)
    {
        tArea.setText(s);
    }
    public static void main(String[] st)
    {
        SwingUtilities.invokeLater( new Runnable()
        {
            @Override
            public void run()
            {
                MainFrame mf = new MainFrame();
                mf.prepareAndShowGUI();
            }
        });
    }
}
class InputBoard extends JFrame implements DocumentListener
{
    MainFrame mainFrame ;
    JTextField inField;
    public InputBoard(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }
    public void prepareGUI()
    {
        setTitle("Input Board");
        inField = new JTextField(40);
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(inField);
        inField.getDocument().addDocumentListener(this);
        setLocationRelativeTo(mainFrame);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
    }
    @Override
    public void changedUpdate(DocumentEvent evt)
    {
        mainFrame.setText(inField.getText());
    }
    @Override
    public void insertUpdate(DocumentEvent evt)
    {
        mainFrame.setText(inField.getText());
    }
    @Override
    public void removeUpdate(DocumentEvent evt)
    {
        mainFrame.setText(inField.getText());
    }
}