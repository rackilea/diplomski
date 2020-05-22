package nexusInsurance;
//TODO export to pdf to email

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.*;
import java.io.FileNotFoundException;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.border.*;

public final class NewClaimNotification extends JPanel implements ActionListener
{
//misc
GridBagLayout layout        = new GridBagLayout();
GridBagConstraints c        = new GridBagConstraints();
static JDialog dialog       = new JDialog();
Boolean updated             = false;
String timeOut              = null;
DateFormat dateFormat       = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Border border               = new LineBorder(Color.BLACK, 1);
static JPanel mainPanel     = new JPanel();

//menu components
JMenuBar menuBar            = new JMenuBar();
JMenu optionsMenu           = new JMenu("Options");
JMenu helpMenu              = new JMenu("Help");
JMenuItem updateItem        = new JMenuItem("Update");
JMenuItem saveItem          = new JMenuItem("Save");
JMenuItem cancelItem        = new JMenuItem("Cancel");
JMenuItem notesItem         = new JMenuItem("Notes");
JMenuItem emailItem         = new JMenuItem("Email");

//header components
JLabel heading              = new JLabel("New Claim Notification");
JLabel lblJobCode           = new JLabel("Job No.");
JFormattedTextField txtTimeIn   = new JFormattedTextField();
JTextField txtJobCode       = new JTextField();
JTextField txtICCode        = new JTextField();
JTextField txtCityCode      = new JTextField();

//claim details components
JLabel lblClaimCause        = new JLabel("Nature of Claim");
JLabel lblLossDate          = new JLabel("Date of Loss");
JLabel lblPHName            = new JLabel("Policy Holder");
JComboBox ddClaimCause      = new JComboBox();
JComboBox ddPHName          = new JComboBox();
JTextField txtLossDate      = new JTextField();
JTextField txtPolCode       = new JTextField();
JTextField txtExcess        = new JTextField(15);
JTextField txtClaimCode     = new JTextField();
JTextField txtCons          = new JTextField();
JTextField txtICName        = new JTextField(30);
JTextField txtBro           = new JTextField();
JTextField txtManAg         = new JTextField();

//SP components
JLabel lblAssessor          = new JLabel("Assessor");
JLabel lblApp               = new JLabel("Appointment");
JComboBox ddAssessor        = new JComboBox();;
JTextField txtHandler       = new JTextField();
JTextField txtApp           = new JTextField();

//risk address components
JLabel lblContact           = new JLabel("Contact");
JTextField txtUnit          = new JTextField();
JTextField txtStreet        = new JTextField();
JTextField txtSuburb        = new JTextField();
JTextField txtCity          = new JTextField();
JTextField txtContact       = new JTextField();
JTextField txtHomeCell      = new JTextField();
JTextField txtHome          = new JTextField();
JTextField txtWork          = new JTextField();
JTextField txtHomeFax       = new JTextField();
JTextField txtOther         = new JTextField();
JTextField txtHomeEmail     = new JTextField();

//banner components
JLabel lblCompanyBanner     = new JLabel();
ImageIcon companyBanner     = new ImageIcon(getClass().getResource("companyBannerLandscape.PNG"));

Statement stmt = null;
String connectionUrl = null;
static ResultSet rs = null;
Connection con = null;
String SQL = null;
Boolean status = false;


private NewClaimNotification(String func, String jobCode) throws SQLException, ClassNotFoundException
{
    Class.forName("com.mysql.jdbc.Driver");
    connectionUrl = "jdbc:mysql://localhost/nexus_insurance?user=root&password=P7683286r!";
    con = DriverManager.getConnection(connectionUrl);
    stmt = con.createStatement();

    PrepareForm(func, jobCode);
    setLayout(layout);
    c.anchor = GridBagConstraints.LINE_START;

    cancelItem.setActionCommand("cancel");
    cancelItem.addActionListener(this);
    notesItem.setActionCommand("viewClaimNotes");
    notesItem.addActionListener(this);
    emailItem.setActionCommand("email");
    emailItem.addActionListener(this);
    optionsMenu.add(notesItem);
    optionsMenu.add(cancelItem);
    optionsMenu.add(emailItem);
    menuBar.add(optionsMenu);
    menuBar.add(helpMenu);
    c.gridy = 0;
    c.gridx = 0;
    menuBar.setPreferredSize(new Dimension(1040,20));
    add(menuBar,c);

    c.gridy = 1;
    lblCompanyBanner.setIcon(new ImageIcon(getClass().getResource("companyBannerLandscape.PNG")));
    add(lblCompanyBanner,c);

    c.gridy = 2;
    c.insets = new Insets(0,30,0,0);
    add(HeaderPanel(),c);

    c.gridy = 3;
    add(ClaimDetailsPanel(),c);

    c.gridy = 4;
    c.insets = new Insets(5,30,5,0);
    add(RiskAddressPanel(),c);

    c.gridy = 5;
    c.insets = new Insets(0,30,10,0);
    add(SPPanel(),c);

    setBackground(Color.white);
    setBorder(border);
}

private JPanel HeaderPanel()
{
    JPanel panel = new JPanel();
    GridBagConstraints x = new GridBagConstraints();
    panel.setLayout(layout);
    x.anchor = GridBagConstraints.LINE_START;

    x.insets        = new Insets(0,0,0,440);
    x.anchor        = GridBagConstraints.LINE_START;
    x.gridy         = 0;
    x.gridx         = 0;
    x.gridheight    = 2;
    heading.setFont(new Font(null, Font.BOLD, 30));
    panel.add(heading, x);
    x.gridheight    = 1;
    x.insets        = new Insets(0,0,0,0);
    x.gridx         = 1;
    lblJobCode.setForeground(Color.red);
    panel.add(lblJobCode, x);
    x.gridx         = 2;
    txtICCode.setEnabled(false);
    txtICCode.setColumns(4);
    panel.add(txtICCode, x);
    x.gridx         = 3;
    txtCityCode.setColumns(4);
    txtCityCode.setEnabled(false);
    panel.add(txtCityCode, x);
    x.gridx         = 4;
    txtJobCode.setColumns(5);
    panel.add(txtJobCode, x);

    x.gridy         = 1;
    x.gridx         = 1;
    panel.add(new JLabel("Date"), x);
    x.gridx         = 2;
    x.gridwidth     = 3;
    txtTimeIn.setEnabled(false);
    x.fill          = GridBagConstraints.HORIZONTAL;
    panel.add(txtTimeIn, x);

    panel.setBackground(Color.white);
    return panel;
}

private JPanel ClaimDetailsPanel()
{
    JPanel panel = new JPanel();
    GridBagConstraints x = new GridBagConstraints();
    panel.setLayout(layout);
    x.anchor = GridBagConstraints.LINE_START;

    x.insets        = new Insets(0,5,0,10);
    x.gridx         = 0;
    x.gridy         = 0;
    lblClaimCause.setForeground(Color.red);
    panel.add(lblClaimCause,x);
    x.gridy         = 1;
    lblLossDate.setForeground(Color.red);
    panel.add(lblLossDate,x);
    x.gridy         = 2;
    lblPHName.setForeground(Color.red);
    panel.add(lblPHName, x);
    x.gridy         = 3;
    panel.add(new JLabel("Policy Code"), x);

    x.insets        = new Insets(0,0,0,88);
    x.fill          = GridBagConstraints.HORIZONTAL;
    x.gridx         = 1;
    x.gridy         = 0;
    ddClaimCause.setEditable(true);
    panel.add(ddClaimCause,x);
    x.gridy         = 1;
    panel.add(txtLossDate,x);
    x.gridy         = 2;
    panel.add(ddPHName,x);
    x.gridy         = 3;
    txtPolCode.setEnabled(false);
    panel.add(txtPolCode,x);
    x.fill          = GridBagConstraints.NONE;

    x.insets        = new Insets(0,0,0,10);
    x.gridx         = 2;
    x.gridy         = 0;
    panel.add(new JLabel("Excess"),x);
    x.gridy         = 1;
    panel.add(new JLabel("Claim Code"),x);
    x.gridy         = 2;
    panel.add(new JLabel("Consultant"),x);
    x.gridy         = 3;
    panel.add(new JLabel("Insurance Co."),x);

    x.insets        = new Insets(0,0,0,95);
    x.fill          = GridBagConstraints.HORIZONTAL;
    x.gridx         = 3;
    x.gridy         = 0;
    panel.add(txtExcess,x);
    x.gridy         = 1;
    panel.add(txtClaimCode,x);
    x.gridy         = 2;
    txtCons.setEnabled(false);
    panel.add(txtCons,x);
    x.gridy         = 3;
    x.gridwidth     = 3;
    txtICName.setEnabled(false);
    panel.add(txtICName,x);
    x.gridwidth     = 1;
    x.fill          = GridBagConstraints.NONE;

    x.insets        = new Insets(0,0,0,10);
    x.gridx         = 4;
    x.gridy         = 0;
    panel.add(new JLabel("Broker"), x);
    x.gridy         = 1;
    panel.add(new JLabel("Agent"), x);

    x.insets        = new Insets(0,0,0,5);
    x.fill          = GridBagConstraints.HORIZONTAL;
    x.gridx         = 5;
    x.gridy         = 0;
    txtBro.setColumns(15);
    txtBro.setEnabled(false);
    panel.add(txtBro, x);
    x.gridy         = 1;
    txtManAg.setEnabled(false);
    panel.add(txtManAg, x);
    x.fill          = GridBagConstraints.NONE;

    panel.setBackground(Color.white);
    panel.setBorder(BorderFactory.createTitledBorder("Claim Details"));
    return panel;
}

private JPanel RiskAddressPanel()
{
    JPanel panel = new JPanel();
    GridBagConstraints x = new GridBagConstraints();
    panel.setLayout(layout);
    x.anchor = GridBagConstraints.LINE_START;

    x.insets        = new Insets(0,5,0,55);
    x.gridx         = 0;
    x.gridy         = 0;
    panel.add(new JLabel("Unit"),x);
    x.gridy         = 1;
    panel.add(new JLabel("Street"),x);
    x.gridy         = 2;
    panel.add(new JLabel("Suburb"),x);
    x.gridy         = 3;
    panel.add(new JLabel("City"),x);

    x.insets        = new Insets(0,0,0,86);
    x.fill          = GridBagConstraints.HORIZONTAL;
    x.gridx         = 1;
    x.gridy         = 0;
    txtUnit.setColumns(17);
    panel.add(txtUnit,x);
    x.gridy         = 1;
    txtStreet.setEnabled(false);
    panel.add(txtStreet,x);
    x.gridy         = 2;
    txtSuburb.setEnabled(false);
    panel.add(txtSuburb,x);
    x.gridy         = 3;
    txtCity.setEnabled(false);
    panel.add(txtCity,x);
    x.fill          = GridBagConstraints.NONE;

    x.insets        = new Insets(0,0,0,43);
    x.gridx         = 2;
    x.gridy         = 0;
    lblContact.setForeground(Color.red);
    panel.add(lblContact,x);
    x.gridy         = 1;
    panel.add(new JLabel("Cell"),x);
    x.gridy         = 2;
    panel.add(new JLabel("Home"),x);
    x.gridy         = 3;
    panel.add(new JLabel("Work"),x);

    x.insets        = new Insets(0,0,0,98);
    x.fill          = GridBagConstraints.HORIZONTAL;
    x.gridx         = 3;
    x.gridy         = 0;
    txtContact.setColumns(15);
    panel.add(txtContact,x);
    x.gridy         = 1;
    panel.add(txtHomeCell,x);
    x.gridy         = 2;
    panel.add(txtHome,x);
    x.gridy         = 3;
    panel.add(txtWork,x);
    x.fill          = GridBagConstraints.NONE;

    x.insets        = new Insets(0,0,0,17);
    x.gridx         = 4;
    x.gridy         = 1;
    panel.add(new JLabel("Other"),x);
    x.gridy         = 2;
    panel.add(new JLabel("Fax"),x);
    x.gridy         = 3;
    panel.add(new JLabel("Email"),x);

    x.insets        = new Insets(0,0,0,5);
    x.fill          = GridBagConstraints.HORIZONTAL;
    x.gridx         = 5;
    x.gridy         = 1;
    txtOther.setColumns(15);
    panel.add(txtOther,x);
    x.gridy         = 2;
    panel.add(txtHomeFax,x);
    x.gridy         = 3;
    panel.add(txtHomeEmail,x);
    x.fill          = GridBagConstraints.NONE;

    panel.setBackground(Color.white);
    panel.setBorder(BorderFactory.createTitledBorder("Risk Address"));
    return panel;
}

private JPanel SPPanel()
{
    JPanel panel = new JPanel();
    GridBagConstraints x = new GridBagConstraints();
    panel.setLayout(layout);
    x.anchor = GridBagConstraints.LINE_START;

    x.insets        = new Insets(0,5,0,53);
    x.gridy         = 0;
    x.gridx         = 0;
    panel.add(new JLabel("Handler"),x);

    x.insets        = new Insets(0,0,0,84);
    x.fill          = GridBagConstraints.HORIZONTAL;
    x.gridy         = 0;
    x.gridx         = 1;
    txtHandler.setEnabled(false);
    txtHandler.setColumns(17);
    panel.add(txtHandler,x);
    x.fill          = GridBagConstraints.NONE;

    x.insets        = new Insets(0,0,0,33);
    x.gridx         = 2;
    lblAssessor.setForeground(Color.red);
    panel.add(lblAssessor,x);

    x.insets        = new Insets(0,0,0,77);
    x.gridx         = 3;
    panel.add(ddAssessor,x);

    x.insets        = new Insets(0,0,0,14);
    x.gridx         = 4;
    lblApp.setForeground(Color.red);
    panel.add(lblApp,x);

    x.insets        = new Insets(0,0,0,5);
    x.gridx         = 5;
    txtApp.setColumns(15);
    panel.add(txtApp,x);
    x.fill          = GridBagConstraints.NONE;
    x.insets        = new Insets(0,0,0,0);

    panel.setBackground(Color.white);
    panel.setBorder(BorderFactory.createTitledBorder("Service Provider Details"));
    return panel;
}

private void PrepareForm(String func,String jobCode) throws SQLException, ClassNotFoundException
{
    txtTimeIn.setEnabled(false);
    txtTimeIn.setText(dateFormat.format(new Date()));
    txtHandler.setEnabled(false);
    txtHandler.setText(Login.fullName);
    txtJobCode.setText(jobCode);

    SQL = "SELECT DISTINCT(claimCause) FROM claims ORDER BY claimCause";
    rs = stmt.executeQuery(SQL);
    ddClaimCause.addItem("");
    while(rs.next())
    {ddClaimCause.addItem(rs.getString(1));}

    SQL = "SELECT CONCAT(firstName, ' ', lastName) as 'name' FROM address_book WHERE relationship LIKE '%Assessor%' ORDER BY name";
    rs = stmt.executeQuery(SQL);
    ddAssessor.addItem("<Select an Assessor>");
    while(rs.next())
    {ddAssessor.addItem(rs.getString(1));}

    SQL = "SELECT phName FROM policy_holders ORDER BY phName";
    rs = stmt.executeQuery(SQL);
    while(rs.next())
    {ddPHName.addItem(rs.getString(1));}

    if(func.equals("update"))
    {
        jobCode = CheckJobCode.main(jobCode);
        txtJobCode.setEnabled(false);
        updateItem.setActionCommand("update");
        updateItem.addActionListener(this);
        optionsMenu.add(updateItem);

        SQL = "SELECT * FROM claims WHERE jobCode = '" + jobCode + "'";
        rs = stmt.executeQuery(SQL);
        while(rs.next())
        {
            txtJobCode.setText(jobCode);
            txtTimeIn.setText(rs.getString("timeIn"));
            ddClaimCause.setSelectedItem(rs.getString("claimCause"));
            txtExcess.setText(rs.getString("excess"));
            txtLossDate.setText(rs.getString("dateOfLoss"));
            ddPHName.setSelectedItem(rs.getString("phName"));
            ddPHName.setEnabled(false);
            txtClaimCode.setText(rs.getString("claimCode"));
            ddAssessor.setSelectedItem(rs.getString("assessor"));
            txtApp.setText(rs.getString("appointment"));
            txtUnit.setText(rs.getString("unit"));
            txtContact.setText(rs.getString("contactPerson"));
            txtHomeCell.setText(rs.getString("homeCell"));
            txtHome.setText(rs.getString("home"));
            txtWork.setText(rs.getString("work"));
            txtOther.setText(rs.getString("other"));
            txtHomeFax.setText(rs.getString("homeFax"));
            txtHomeEmail.setText(rs.getString("homeEmail"));
        }

        SQL = "SELECT * FROM policy_holders WHERE phName = '" + ddPHName.getSelectedItem() + "'";
        rs = stmt.executeQuery(SQL);
        while(rs.next())
        {
            txtICCode.setText(rs.getString("icCode"));
            txtCityCode.setText(rs.getString("cityCode"));
            txtICName.setText(rs.getString("icName"));
            txtCons.setText(rs.getString("cons"));
            txtBro.setText(rs.getString("bro"));
            txtManAg.setText(rs.getString("manAg"));
            txtPolCode.setText(rs.getString("polCode"));
            txtStreet.setText(rs.getString("phStreet"));
            txtSuburb.setText(rs.getString("phSuburb"));
            txtCity.setText(rs.getString("phCity"));
        }
    }
    else if(func.equals("insert"))
    {
        saveItem.setActionCommand("save");
        saveItem.addActionListener(this);
        optionsMenu.add(saveItem);

        ddPHName.setActionCommand("bind");
        ddPHName.addActionListener(this);
    }
}

public static JPanel PanelView(String func, String jobCode) throws SQLException, ClassNotFoundException
{
    mainPanel = new NewClaimNotification(func,jobCode);
    return mainPanel;
}

public static JDialog DialogView(String func, String jobCode) throws SQLException, ClassNotFoundException
{
    dialog.add(PanelView(func, jobCode));
    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    dialog.setTitle("New Claim Notification");
    dialog.pack();
    dialog.setLocationRelativeTo(null);
    dialog.setResizable(false);
    dialog.setVisible(true);
    return dialog;
}

public void submitForm() throws SQLException, ClassNotFoundException
{
    if(formCompleted())
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        timeOut = dateFormat.format(new Date());

        SQL = "INSERT INTO claims (jobCode,"
                + "timeIn,"
                + "claimCause,"
                + "dateOfLoss,"
                + "phName,"
                + "claimCode,"
                + "unit,"
                + "contactPerson,"
                + "home,"
                + "homeCell,"
                + "work,"
                + "homeEmail,"
                + "handler,"
                + "assessor,"
                + "appointment,"
                + "other,"
                + "homeFax,"
                + "excess,"
                + "notes,"
                + "timeOut)"
                + "VALUES ('"
                + txtJobCode.getText()
                + "','" + txtTimeIn.getText()
                + "','" + ddClaimCause.getSelectedItem()
                + "','" + txtLossDate.getText()
                + "','" + ddPHName.getSelectedItem()
                + "','" + txtClaimCode.getText()
                + "','" + txtUnit.getText()
                + "','" + txtContact.getText()
                + "','" + txtHome.getText()
                + "','" + txtHomeCell.getText()
                + "','" + txtWork.getText()
                + "','" + txtHomeEmail.getText()
                + "','" + txtHandler.getText()
                + "','" + ddAssessor.getSelectedItem()
                + "','" + txtApp.getText()
                + "','" + txtOther.getText()
                + "','" + txtHomeFax.getText()
                + "','" + txtExcess.getText()
                + "','" + "New Claim Notification saved on " + txtTimeIn.getText() + " by " + txtHandler.getText() + "\n"
                + "','" + timeOut + "')";

        stmt.executeUpdate(SQL);

        JOptionPane.showMessageDialog(null, "Record Inserted Succesfully! \nWould you like to add another New Claim?", "Submitted!", JOptionPane.PLAIN_MESSAGE);
        dialog.dispose();
    }
    else
    {
        JOptionPane.showMessageDialog(null, "Please Enter All Required Fields", "Error!", JOptionPane.WARNING_MESSAGE);
    }

}

public boolean formCompleted()
{
    if(txtJobCode.getText().trim().equals(""))
    {
        status = false;
    }
    else if (ddClaimCause.getSelectedItem().equals(""))
    {
    status = false;
    }
    else if (txtLossDate.getText().equals(""))
    {
    status = false;
    }
    else if (ddPHName.getSelectedItem().equals(""))
    {
      status = false;
    }
    else if (txtContact.getText().trim().equals(""))
    {
      status = false;
    }
    else if (ddAssessor.getSelectedItem().equals(""))
    {
        status = false;
    }
    else if (txtApp.getText().trim().equals(""))
    {
        status = false;
    }
    else
    {
    status = true;
    }

    return status;
}

public void actionPerformed(ActionEvent ae)
{
    if (ae.getActionCommand().equals("cancel"))
    {dialog.dispose();}

    else if(ae.getActionCommand().equals("save"))
    {
        try
        {submitForm();}
        catch (SQLException ex)
        {Logger.getLogger(NewClaimNotification.class.getName()).log(Level.SEVERE, null, ex);}            catch (ClassNotFoundException ex)
        {Logger.getLogger(NewClaimNotification.class.getName()).log(Level.SEVERE, null, ex);}
    }
    //todo ncnf update
    else if(ae.getActionCommand().equals("update"))
    {

    }

    else if(ae.getActionCommand().equals("viewClaimNotes"))
    {
        try
        {ViewNotes.main(txtJobCode.getText());}
        catch (ClassNotFoundException ex)
        {Logger.getLogger(NewClaimNotification.class.getName()).log(Level.SEVERE, null, ex);}            catch (SQLException ex)
        {Logger.getLogger(NewClaimNotification.class.getName()).log(Level.SEVERE, null, ex);}
    }

    else if(ae.getActionCommand().equals("bind"))
    {
        try
        {getPolicyHolderDetails();}
        catch (SQLException ex)
        {Logger.getLogger(NewClaimNotification.class.getName()).log(Level.SEVERE, null, ex);}
    }

    else if(ae.getActionCommand().equals("email"))
    {
        try {
            Document document = new Document(PageSize.A4.rotate(), 50, 50, 50, 50);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\HelloWorld.pdf"));
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate tp = cb.createTemplate(mainPanel.getWidth(), mainPanel.getHeight());
            Graphics2D g2 = tp.createGraphics(mainPanel.getWidth(), mainPanel.getHeight());
            g2.scale(0.8, 1.0);
            mainPanel.print(g2);
            g2.dispose();
            cb.addTemplate(tp, 5, 60);
            document.close();
        } catch (DocumentException ex) {
            Logger.getLogger(NewClaimNotification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewClaimNotification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

private void getPolicyHolderDetails() throws SQLException
{
            SQL = "SELECT * FROM policy_holders WHERE phName = '" + ddPHName.getSelectedItem() + "'";
            rs = stmt.executeQuery(SQL);
            while (rs.next())
             {
                txtPolCode.setText(rs.getString("polCode"));
                txtStreet.setText(rs.getString("phStreet"));
                txtSuburb.setText(rs.getString("phSuburb"));
                txtCity.setText(rs.getString("phCity"));
                txtICName.setText(rs.getString("icName"));
                txtCons.setText(rs.getString("cons"));
                txtBro.setText(rs.getString("bro"));
                txtManAg.setText(rs.getString("manAg"));
                txtICCode.setText(rs.getString("icCode"));
                txtCityCode.setText(rs.getString("cityCode"));
              }
}

}