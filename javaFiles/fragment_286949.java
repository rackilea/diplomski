import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TestApplication implements ActionListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
    frame.setSize(1000, 1000);
    frame.setTitle("RBA Test Application");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    JLabel logLabel = new JLabel("Input/Output Log");

    JButton initialize = new JButton("Initialize");
    JButton connect = new JButton("Connect");
    JButton disconnect = new JButton("Disconnect");
    JButton shutdown = new JButton("Shut Down");
    JButton portsettings = new JButton("Port Settings");
    JButton online = new JButton("Go Online");
    JButton offline = new JButton("Go Offline");
    JButton status = new JButton("Status");
    JButton reboot = new JButton("Reboot");
    JButton account = new JButton("Account");
    JButton amount = new JButton("Amount");
    JButton reset = new JButton("Reset");
    JButton apprvordecl = new JButton("Apprv/Decl");
    JButton test = new JButton("Test Button #1");
    JButton testing = new JButton("Test Button #2");
    JRadioButton button = new JRadioButton("Radio Button");
    JRadioButton button2 = new JRadioButton("Radio Button");
    JCheckBox checkbox = new JCheckBox("Check Box");
    JCheckBox checkbox2 = new JCheckBox("Check Box");

    JPanel testPanel = new JPanel();
     testPanel.add(button);
     testPanel.add(button2);
     testPanel.add(checkbox2);

JPanel posPanel = new JPanel();
posPanel.add(test);
posPanel.add(testing);
posPanel.add(checkbox);

//CHANGED PART
JPanel llpPanel = new JPanel(new BorderLayout());
JPanel llpbuttonPanel = new JPanel();
llpbuttonPanel.add(online);
llpbuttonPanel.add(offline);
llpbuttonPanel.add(status);
llpbuttonPanel.add(reboot);
llpbuttonPanel.add(account);
llpbuttonPanel.add(amount);
llpbuttonPanel.add(reset);
llpbuttonPanel.add(apprvordecl);
llpPanel.add(llpbuttonPanel, BorderLayout.NORTH);

JPanel textPanel = new JPanel(new BorderLayout());
textPanel.add(logLabel);
llpPanel.add(textPanel, BorderLayout.CENTER);
//END CHANGED PART

JPanel buttonPanel = new JPanel();
buttonPanel.add(initialize);
buttonPanel.add(connect);
buttonPanel.add(disconnect);
buttonPanel.add(shutdown);
buttonPanel.add(portsettings);
frame.add(buttonPanel);
frame.add(buttonPanel, BorderLayout.NORTH);

JTabbedPane tabbedPane = new JTabbedPane();
tabbedPane.addTab("LLP", null, llpPanel, "Low Level Protocol");
tabbedPane.addTab("POS",null, posPanel, "Point Of Sale");
tabbedPane.addTab("Test", null, testPanel, "Test");

JPanel tabsPanel = new JPanel(new BorderLayout());
tabsPanel.add(tabbedPane);
frame.add(tabsPanel, BorderLayout.CENTER);


frame.pack();



}

@Override
public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub

}






}