try{
      String url = "jdbc:mysql://localhost:3306/adv"; 
        Connection conn = DriverManager.getConnection(url,"root","sa"); 
        Statement st = conn.createStatement();
        String query = "SELECT CustomerNo, FName, FROM roominfo WHERE FName LIKE '%" + jTextField2.getText() + "%'";
      rs = st.executeQuery(query);
      jTable2.setModel(DbUtils.resultSetToTableModel(rs)); 

    conn.close();

}
     catch (Exception e) { 
        JOptionPane.showMessageDialog(null,"Got an exception!");
        System.err.println(e.getMessage()); 
    }