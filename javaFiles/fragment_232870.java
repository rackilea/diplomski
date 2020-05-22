import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

//!! import com.toedter.calendar.*; //!! we don't have this package

public class NewPatient extends JFrame implements ActionListener, ItemListener {
   // ////////////////////// new patient labels
   // !! enter code here //!! WTF??? this shouldn't be here, non commented
   private JLabel name;
   private JLabel sname;
   private JLabel initial;
   private JLabel gender;
   private JLabel address;
   private JLabel confirm;
   private JLabel phone;
   private JLabel email;
   private JLabel dob;
   private JLabel country;
   private JLabel city;
   private JLabel province;
   private JLabel balance;
   private JLabel userName;
   private JLabel password;
   private JLabel mail;
   private JLabel folderLabel;
   private JLabel idLabel;
   private JLabel label;
   private JLabel label1;
   // ///////////////////////////// new patient textfields
   private JTextField nameField;
   private JTextField snameField;
   private JTextField initialField;
   // private JTextField dobField;
   private JTextField provinceField;
   private JTextField phoneField;
   private JTextField emailField;
   private JTextField balanceField;
   private JTextField userNameField;
   private JTextField folderField;
   private JTextField idField;
   private JTextField cityField;
   private JTextField mailField;
   // /////////////////// state province combo box
   private JComboBox countryBox;
   // private JComboBox cityBox;
   // private JComboBox provinceBox;
   // ////////////// password fields
   private JPasswordField passwordField;
   private JPasswordField confirmField;
   // /////////////// radio buttons
   private JRadioButton maleBtn;
   private JRadioButton femaleBtn;
   // ///////////// radio button group
   private ButtonGroup groupSex;
   // //////////////panel to containt components
   private JPanel container;
   // ///////////// fonts
   Font labeNameFont = null;
   // //////////// text area
   private JTextArea addressArea;
   // ///////////// box
   private Box boxArea;
   // /////////////////////// variables
   private static final String[] countryNames = { "", "BOTSWANA", "CONGO",
         "DR CONGO", "SOUTH AFRICA", "RWANDA", "ZIMBABWE" };
   // //////////////////// buttons
   private JButton back;
   private JButton clear;
   private JButton send;

   // ///////////// calendar
   // !! private JDateChooser chooser;
   public NewPatient() {
      super("NEW PATIENT");
      this.setSize(600, 580);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setResizable(false);
      // /////////////////// labels fonts
      labeNameFont = new Font("SansSerif", Font.BOLD, 12);
      // ////////////// initializing and setting the main panel
      container = new JPanel();
      Border titleBorder = new TitledBorder(new LineBorder(Color.BLACK),
            "REGISTER");
      container.setBorder(titleBorder);
      container.setLayout(null);
      // ////////////////////// folder
      folderLabel = new JLabel("FOLDER NUMBER:");
      folderLabel.setBounds(140, 30, 110, 25);
      folderLabel.setFont(labeNameFont);
      folderField = new JTextField(15);
      folderField.setBounds(250, 30, 90, 27);
      folderField.setEditable(false);
      folderField.setBackground(Color.YELLOW);
      folderField.setText(patientNum());
      folderField.setFont(labeNameFont);
      // ////////////////// name
      name = new JLabel("NAME(S):");
      name.setBounds(10, 85, 80, 15);
      name.setFont(labeNameFont);
      nameField = new JTextField();
      nameField.setBounds(80, 80, 150, 27);
      nameField.setFont(labeNameFont);
      // //////////////////// initial
      initial = new JLabel("INITIAL:");
      initial.setFont(labeNameFont);
      initial.setBounds(347, 82, 80, 20);
      initialField = new JTextField(15);
      initialField.setBounds(407, 80, 60, 27);
      initialField.setFont(labeNameFont);
      // /////////////// surname
      sname = new JLabel("SURNAME:");
      sname.setBounds(10, 119, 80, 15);
      sname.setFont(labeNameFont);
      snameField = new JTextField(15);
      snameField.setBounds(80, 115, 150, 27);
      snameField.setFont(labeNameFont);
      // //////////////////////////// gender radio and group button
      gender = new JLabel("GENDER:");
      gender.setBounds(347, 117, 80, 15);
      gender.setFont(labeNameFont);
      maleBtn = new JRadioButton("MALE");
      maleBtn.setBounds(407, 114, 80, 20);
      maleBtn.setFont(labeNameFont);
      femaleBtn = new JRadioButton("FEMALE");
      femaleBtn.setFont(labeNameFont);
      femaleBtn.setBounds(490, 114, 80, 20);
      groupSex = new ButtonGroup();
      groupSex.add(maleBtn);
      groupSex.add(femaleBtn);
      // ////////////////// id
      idLabel = new JLabel("ID NUM:");
      idLabel.setBounds(10, 154, 80, 15);
      idLabel.setFont(labeNameFont);
      idField = new JTextField(15);
      idField.setBounds(80, 150, 150, 27);
      idField.setFont(labeNameFont);
      // /////////////////// address
      address = new JLabel("Address:");
      address.setBounds(347, 154, 70, 15);
      address.setFont(labeNameFont);
      boxArea = Box.createHorizontalBox();
      addressArea = new JTextArea(10, 10);
      addressArea.setLineWrap(true);
      addressArea.setFont(labeNameFont);
      boxArea.setBounds(407, 150, 150, 80);
      boxArea.setFont(labeNameFont);
      boxArea.add(new JScrollPane(addressArea));
      // /////////// date of birth
      dob = new JLabel("D.O.B:");
      dob.setBounds(10, 190, 50, 15);
      dob.setFont(labeNameFont);
      /*
       * dobField = new JTextField(15); dobField.setBounds(80,185,150,27);
       * dobField.setFont(labeNameFont);
       */
      // !! chooser = new JDateChooser();
      // chooser.setFont(labeNameFont);
      // chooser.setBounds(80,185,150,27);
      // ///////////////////////// country
      country = new JLabel("COUNTRY:");
      country.setBounds(10, 230, 70, 15);
      country.setFont(labeNameFont);
      countryBox = new JComboBox(countryNames);
      countryBox.setBounds(80, 225, 150, 27);
      countryBox.setFont(labeNameFont);
      countryBox.setMaximumRowCount(3);
      // /////////////////////////////////// city
      city = new JLabel("CITY:");
      city.setFont(labeNameFont);
      city.setBounds(347, 248, 70, 15);
      // city.setVisible(false);
      cityField = new JTextField(15);
      cityField.setFont(labeNameFont);
      cityField.setBounds(407, 242, 150, 27);
      // cityField.setVisible(false);
      cityField.setEditable(false);
      // //////////////////// province
      province = new JLabel("PROVINCE:");
      province.setBounds(10, 271, 80, 15);
      province.setFont(labeNameFont);
      provinceField = new JTextField(15);
      provinceField.setFont(labeNameFont);
      provinceField.setBounds(80, 267, 150, 27);
      provinceField.setEditable(false);
      // /////////////////////// phone
      phone = new JLabel("PHONE:");
      phone.setBounds(10, 313, 70, 15);
      phone.setFont(labeNameFont);
      phoneField = new JTextField(15);
      phoneField.setBounds(80, 306, 150, 27);
      phoneField.setFont(labeNameFont);
      // /////////////////////// email
      email = new JLabel("EMAIL:");
      email.setBounds(347, 288, 70, 15);
      email.setFont(labeNameFont);
      emailField = new JTextField(15);
      emailField.setBounds(409, 282, 150, 27);
      emailField.setFont(labeNameFont);
      mail = new JLabel("CONFIRM EMAIL:");
      mail.setBounds(347, 335, 100, 15);
      mail.setFont(labeNameFont);
      mailField = new JTextField(15);
      mailField.setBounds(410, 360, 150, 27);
      mailField.setFont(labeNameFont);
      label1 = new JLabel("\" name@kalilinux.org \"");
      label1.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 12));
      label1.setBounds(420, 300, 150, 27);
      // ///////////// phone formaat label
      // Font font = null;
      label = new JLabel("(0XX-XXX-XXXX)");
      label.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 12));
      label.setBounds(100, 325, 150, 27);
      // ////////////// address
      balance = new JLabel("BALANCE:");
      balance.setBounds(10, 360, 70, 15);
      balance.setFont(labeNameFont);
      balanceField = new JTextField(15);
      balanceField.setBounds(80, 357, 150, 27);
      balanceField.setFont(labeNameFont);
      // /////// username and password
      userName = new JLabel("USER NAME:");
      userName.setBounds(10, 395, 100, 15);
      userName.setFont(labeNameFont);
      userNameField = new JTextField(15);
      userNameField.setBounds(80, 392, 150, 27);
      userNameField.setFont(labeNameFont);
      password = new JLabel("PASSWORD:");
      password.setBounds(10, 435, 80, 15);
      password.setFont(labeNameFont);
      passwordField = new JPasswordField(15);
      passwordField.setBounds(80, 432, 150, 27);
      passwordField.setFont(labeNameFont);
      confirm = new JLabel("CONFIRM PASSWORD:");
      confirm.setBounds(347, 403, 150, 15);
      confirm.setFont(labeNameFont);
      confirmField = new JPasswordField(15);
      confirmField.setBounds(410, 425, 150, 27);
      confirmField.setFont(labeNameFont);
      // //////////////////////////// back
      back = new JButton("BACK");
      back.setFont(labeNameFont);
      back.setBounds(80, 490, 80, 27);
      // /////////////////////// clear
      clear = new JButton("CLEAR");
      clear.setFont(labeNameFont);
      clear.setBounds(280, 490, 80, 27);
      // /////////////////////// Proceed
      send = new JButton("SUBMIT");
      send.setFont(labeNameFont);
      send.setBounds(480, 490, 80, 27);
      // //////////////add components to panel
      registerPatient();
      // /////////////// register button events
      back.addActionListener(this);
      clear.addActionListener(this);
      send.addActionListener(this);
      countryBox.addItemListener(this);
      // //////////adding panel
      add(container);
   }

   public String patientNum() {
      Random numberGenerated = new Random();
      String myNumGen = " MKW - ";
      int starter;
      starter = 473 + numberGenerated.nextInt(9528);
      String start = String.format("%d", starter);
      return myNumGen + " " + start;
   }

   public void registerPatient() {
      container.add(folderLabel);
      container.add(folderField);
      container.add(name);
      container.add(nameField);
      container.add(sname);
      container.add(snameField);
      container.add(idLabel);
      container.add(idField);
      container.add(dob);
      // container.add(dobField);
      // !! container.add(chooser);
      container.add(initial);
      container.add(initialField);
      container.add(gender);
      container.add(maleBtn);
      container.add(femaleBtn);
      container.add(address);
      container.add(boxArea);
      container.add(country);
      container.add(countryBox);
      container.add(city);
      container.add(cityField);
      container.add(province);
      container.add(provinceField);
      container.add(phone);
      container.add(phoneField);
      container.add(label);
      container.add(label1);
      container.add(email);
      container.add(emailField);
      container.add(balance);
      container.add(balanceField);
      container.add(mail);
      container.add(mailField);
      container.add(userName);
      container.add(userNameField);
      container.add(password);
      container.add(passwordField);
      container.add(confirm);
      container.add(confirmField);
      // //////// add buttons
      container.add(back);
      container.add(clear);
      container.add(send);
      this.setVisible(true);
      this.setLocation(500, 80);
   }

   // ///////////////// clear fields
   public void clearFields() {
      folderField.setText(patientNum());
      folderField.setFont(labeNameFont);
      nameField.setText("");
      initialField.setText("");
      snameField.setText("");
      idField.setText("");
      // !! chooser.setCalendar(null);
      provinceField.setText("");
      cityField.setText("");
      emailField.setText("");
      confirmField.setText("");
      passwordField.setText("");
      mailField.setText("");
      userNameField.setText("");
      balanceField.setText("");
      addressArea.setText("");
      phoneField.setText("");
      countryBox.setSelectedIndex(0);
      groupSex.clearSelection();
      // femaleBtn.setSelected(false);
   }

   // ////////////////////// triggering events
   public void itemStateChanged(ItemEvent myevent) {
      Object selected = countryBox.getSelectedItem();
      if (selected.toString().equals("")) {
         provinceField.setText("");
         cityField.setText("");
      } else if (selected.toString().equals("BOTSWANA")) {
         provinceField.setText("SOUTH-EAST");
         cityField.setText("GABORONE");
      } else if (selected.toString().equals("CONGO")) {
         provinceField.setText("POOL");
         cityField.setText("BRAZAVILLE");
      } else if (selected.toString().equals("DR CONGO")) {
         provinceField.setText("KINSHASA");
         cityField.setText("KINSHASA");
      } else if (selected.toString().equals("SOUTH AFRICA")) {
         provinceField.setText("WESTERN CAPE");
         cityField.setText("CAPE TOWN");
      } else if (selected.toString().equals("RWANDA")) {
         provinceField.setText("KIGALI");
         cityField.setText("KIGALI CITY");
      } else if (selected.toString().equals("ZIMBABWE")) {
         provinceField.setText("HARARE");
         cityField.setText("HARARE");
      }
   }

   public void actionPerformed(ActionEvent event) {
      if (event.getActionCommand().equals("BACK")) {
         PatientPanel patient = new PatientPanel();
         patient.setVisible(true);
         patient.setLocation(500, 250);
         dispose();
      }
      if (event.getActionCommand().equals("CLEAR")) {
         clearFields();
      }
      if (event.getActionCommand().equals("SUBMIT")) {
         // ValidateInput validateData = new ValidateInput(); //// input
         // validation
         FullDetails mydetails = new FullDetails();
         System.out.println("gtmtfsgsdg");
         try {
            if (!ValidateInput.validateFirstName(nameField.getText())) {
               System.out.println("youtube");
               String message = String
                     .format("Invalid Format!!! NAME must only be one word");
               JOptionPane.showMessageDialog(null, message, "ERROR",
                     JOptionPane.ERROR_MESSAGE);
            } else {
               mydetails.setFirstName(nameField.getText());
               if (!ValidateInput.validateSurName(snameField.getText())) {
                  String msg = String
                        .format("Invalid Format!!! SURNAME must only be one word");
                  JOptionPane.showMessageDialog(null, msg, "ERROR",
                        JOptionPane.ERROR_MESSAGE);
               } else {
                  mydetails.setSurname(snameField.getText());
               }
            }
         } catch (Exception e) {
            String msg = String
                  .format("Invalid input. Please make sure that you have filled every text fields!!! Please enter a correct one");
            JOptionPane.showMessageDialog(null, msg, "ERROR",
                  JOptionPane.ERROR_MESSAGE);
         }
      }
   }

   private static void createAndShowGui() {
      NewPatient gui = new NewPatient();
      gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      gui.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

class ValidateInput {
   public static boolean validateFirstName(String firstName) {
      return firstName.matches("[a-zA-Z]*");
   }

   public static boolean validateSurName(String surname) {
      return surname.matches("[A-zA-z]+(['-][a-zA-Z]+)*");
   }

   public static boolean validateInitial(String initial) {
      return initial.matches("[A-Z]*");
   }
}

class FullDetails {
   // !! These fields should not be static
   private static String firstName;
   private static String surname;

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setSurname(String surname) {
      this.surname = surname;
   }

   public String getSurname() {
      return surname;
   }

   public static String getSurnam() {
      return surname;
   }
}

//!! a bare bones class to allow your code to compile
class PatientPanel extends JPanel {
   public PatientPanel() {
      add(new JLabel("Patient Panel"));
      setBorder(BorderFactory.createTitledBorder("Patient Panel"));
   }
}