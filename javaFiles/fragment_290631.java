import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

public class ChangeOptionTF extends JPanel implements ActionListener {

    private static final long serialVersionUID = 3355314012553851743L;
    private JTextField tf;
    private JButton saveBtn;

    private EventListenerList listeners;

    public ChangeOptionTF(String label) {

        listeners = new EventListenerList();

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        JLabel jLabel = new JLabel(label);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        add(jLabel, c);

        tf = new JTextField();