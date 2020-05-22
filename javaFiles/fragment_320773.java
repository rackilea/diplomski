void loadcombo() {
    try
    {
    // Your database connections 

rs= st.executeQuery("select Column from Table");
    while(rs.next()){                            
        jComboBox.addItem(rs.getString(1));
    }
    con.close();
    }
    catch(Exception e)
    {
        System.out.println("Error"+e);
    }    
}