private void fillTable(String keyword) throws SQLException{
    if (!keyword.equals("")){
        try( Connection con = DriverManager.getConnection
                            ("jdbc:mysql://localhost:3306/inventory?zero"
                                    + "DateTimeBehavior=convertToNull","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM basis "
                    + "WHERE barcode LIKE '%"+keyword+"%' or "
                    + "namaProduk LIKE '%"+keyword+" %'");               
        ){
            jTable1.setModel(buildTableModel(rs));
        }  
    }
    else fillTable();
}