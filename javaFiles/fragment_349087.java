rs.next();
String name = rs.getString("type"); 

if (name.equals("admin")) {
    AdminHome ah = new AdminHome();
    ah.setVisible(true);
}
 else {
    EmployeeHome eh = new EmployeeHome();
    eh.setVisible(true);
}