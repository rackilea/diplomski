import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class DialogTesting {

    protected void initUI() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField txtUserName, txtHostName, txtPortNo, txtSID;
        JPasswordField txtPassword;
        JPanel mainPanel;
        JCheckBox chkBoxSaveConnection;

        GridBagConstraints firstCol = new GridBagConstraints();
        firstCol.weightx = 1.0;
        firstCol.anchor = GridBagConstraints.WEST;
        firstCol.insets = new Insets(5, 20, 5, 5);

        GridBagConstraints lastCol = new GridBagConstraints();
        lastCol.gridwidth = GridBagConstraints.REMAINDER;
        lastCol.weightx = 1.0;
        lastCol.fill = GridBagConstraints.HORIZONTAL;
        lastCol.insets = new Insets(5, 5, 5, 20);

        mainPanel = new JPanel(new GridBagLayout());

        JLabel l_label = null;
        txtUserName = new JTextField("K_USERNAME", 15);
        txtUserName.putClientProperty("maxlength", 200);
        l_label = new JLabel("User Name");
        mainPanel.add(l_label, firstCol);
        mainPanel.add(txtUserName, lastCol);

        txtPassword = new JPasswordField("K_PASSWORD", 15);
        txtUserName.putClientProperty("maxlength", 200);
        l_label = new JLabel("Password");
        mainPanel.add(l_label, firstCol);
        mainPanel.add(txtPassword, lastCol);

        txtHostName = new JTextField("K_HOSTNAME", 15);
        txtHostName.putClientProperty("maxlength", 200);
        l_label = new JLabel("Host Name");
        mainPanel.add(l_label, firstCol);
        mainPanel.add(txtHostName, lastCol);

        txtPortNo = new JTextField("K_PORTNO", 15);

        l_label = new JLabel("Port Number");
        txtPortNo.putClientProperty("maxlength", 200);
        mainPanel.add(l_label, firstCol);
        mainPanel.add(txtPortNo, lastCol);

        txtSID = new JTextField("K_SID", 15);
        l_label = new JLabel("SID number");
        txtPortNo.putClientProperty("maxlength", 200);
        mainPanel.add(l_label, firstCol);
        mainPanel.add(txtSID, lastCol);

        chkBoxSaveConnection = new JCheckBox();
        l_label = new JLabel("chkBoxSaveConnection");
        mainPanel.add(l_label, firstCol);
        mainPanel.add(chkBoxSaveConnection, lastCol);

        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DialogTesting().initUI();
            }
        });
    }
}