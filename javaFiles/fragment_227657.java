public EmployeeHome(String userName) {
    initComponents();
    userLabel.setText(userName);
    conn = dbconnect.ConnectDB();
    DateTime ();
}