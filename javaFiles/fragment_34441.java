import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class MainWindow
{
    public static void main (String [] a) {
        SwingUtilities.invokeLater (new Runnable () {
            @Override public void run () {
                try {
                    UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName ());
                    createAndShowGUI ();
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog (null, "An unexpected error occurred: " + e.getClass ().getSimpleName (), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    private static void createAndShowGUI () {
        JFrame frame = new JFrame ("TextFieldUpdateIssue");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setContentPane (new MainPanel ());
        frame.setExtendedState (JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo (null);
        frame.setVisible (true);
    }
}
class MainPanel extends JPanel
{
    private JPanel tagsPanel;

    public MainPanel () {
        super (new BorderLayout (0, 10));
        add (new JButton (new AbstractAction ("Add tag") {
             @Override public void actionPerformed(ActionEvent e) {
                addNewTag ();
            }
        }), BorderLayout.NORTH);
        tagsPanel = new JPanel ();
        tagsPanel.setLayout (new FlowLayout (FlowLayout.CENTER, 10, 0));
        add (tagsPanel, BorderLayout.CENTER);
    }
    private void addNewTag () {
        TagVisual v = new TagVisual ();
        tagsPanel.add (v);
        v.grabFocusOnField ();
        revalidate ();
    }
}
class TagVisual extends JPanel
{
    private JTextField editField;

    public TagVisual() {
        super (new FlowLayout (FlowLayout.CENTER, 0, 0));
        add (editField = createNewTextField (null), FlowLayout.LEFT);
    }
    private JTextField createNewTextField (String text) {
        JTextField textField = new JTextField (text) {
            @Override public Dimension getPreferredSize () {
                Dimension d = super.getPreferredSize ();
                return new Dimension (new JLabel (getText ()).getPreferredSize ().width + 10, d.height);
            }
        };
        textField.setBackground (Color.RED);
        textField.getDocument ().addDocumentListener (new DocumentListener () {
            @Override public void changedUpdate (DocumentEvent e) {
                revalidate ();
            }
            @Override public void insertUpdate (DocumentEvent e) {
                revalidate ();
            }
            @Override public void removeUpdate (DocumentEvent e) {
                revalidate ();
            }
        });
        return textField;
    }
    public void grabFocusOnField () {
        editField.grabFocus ();
        editField.setCaretPosition (editField.getText ().length ());
    }
}