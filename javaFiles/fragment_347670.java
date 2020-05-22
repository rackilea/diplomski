public Object[][] userData;
final public String[] userColumns =  {"Acc Number", "Firstname", "Lastname", "Cost ","Hours", "Time","Date","Approved"};
final DefaultTableModel userTableModel = new DefaultTableModel(userData, userColumns);
final JTable userTable = new JTable(userTableModel);


public class ADMIN implements ActionListener {    
    public void actionPerformed(ActionEvent ev) {
        AdminGUI a = new AdminGUI(userTableModel);
        a.getClass();
    }
}