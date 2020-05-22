final Object example[] = new Object[rowCount];

    try{
        int row = 0;
        Statement st = conn.createStatement();
        rs = st.executeQuery("SELECT DISTINCT Name FROM Table1");
        while(rs.next()){
                example[row] = rs.getString("Name");
                row++;
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "DBComboBoxFill error: " + e);
    }