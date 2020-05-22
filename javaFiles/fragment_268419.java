DefaultTableModel model;        
 public MyJframeForm() {
    initComponents();         
    model = new DefaultTableModel();
    jTable1.setModel(model);
    model.addColumn("OstadName");
    model.addColumn("DarsName");
    LoadGridData();
}

public void LoadGridData() {
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost/NewDatabase");
        Statement sta = con.createStatement();

        java.sql.ResultSet rs = sta.executeQuery("SELECT OSTAD.NAAM || ' ' || OSTAD.NAAMKHANEVADEGI as OstadName,"
                + " DARS.NAAM AS DarsName"
                + " FROM (OSTAD INNER JOIN OSTAD_DARS ON OSTAD.ID=OSTAD_DARS.OID )"
                + " INNER JOIN DARS ON OSTAD_DARS.DID=DARS.ID");

        while (rs.next()) {
            model.addRow(new Object[]{rs.getString(1), rs.getString(2)});
        }

        sta.close();
        con.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Exception: " + e.getMessage());
    }
}