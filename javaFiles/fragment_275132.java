private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {  
String hours = null;
 try
    {
        DbUpdate up = new DbUpdate();

        int get = (int)jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 0);
        String query= "SELECT * FROM roominfo WHERE CustomerNo = '"+get+"' " ;

        String url = "jdbc:mysql://localhost:3306/adv"; 
        Connection conn = DriverManager.getConnection(url,"root","sa"); 
        Statement st = conn.createStatement();
        rs = st.executeQuery(query);


        while(rs.next())
        {
         hours= rs.getString("Hours");
}
 if (hours.equals("12-Hours")) {
        // you can change the fields of the second frame directly in here
        up.Rdn12.isSelected();
        up.Rdn12.setSelected(true);
        up.Rdn24.setSelected(false);

    } else if (hours.equals("24-Hours")) {
        up.Rdn24.isSelected();
        up.Rdn12.setSelected(false);
        up.Rdn24.setSelected(true);
    }

    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, "Please select a record to update");
    }


}