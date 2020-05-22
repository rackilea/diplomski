private ArrayList<String> getCanciones(int codDisco) {
    // TODO Auto-generated method stub
    ArrayList<String> x=new ArrayList<String>();
    String[] values = null;
    ARRAY array;
    String sql = "SELECT canciones from TDisco where codDisco = "+codDisco;
    try {
        PreparedStatement select = con.prepareStatement(sql);
        System.out.println(sql);
        ResultSet rs = select.executeQuery(sql);
        while(rs.next()){
            array = (ARRAY) rs.getArray(1);
            values = (String[]) array.getArray();
        };

    } catch (SQLException e) {
        e.printStackTrace();

    }
    for (int i = 0; i < values.length; i++) {
         x.add(values[i]);  
    }

    return x;
}