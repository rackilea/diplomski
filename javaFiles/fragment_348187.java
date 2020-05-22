public List<MyDataClass> listMyData(Connection con, String partNumber) {
    ArrayList<MyDataClass> list = new ArrayList<MyDataClass>();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = con.prepareStatement("SELECT PART_NO, DESC, PRICE FROM MYTABLE WHERE PART_NO = ?");
        ps.setString(1, partNumber);
        rs = ps.executeQuery();
        while(rs.next()) {
            MyDataClass myData = new MyDataClass();
            myData.setPartNumber(rs.getString("PART_NO"));
            myData.setDescription(rs.getString("DESC"));
            myData.setPrice(rs.getBigDecimal("PRICE"));
            list.add(myData);
        }
        con.commit();
    }
    catch(Throwable thrown) {
        try{ con.rollback(); }catch(Throwable t){}
        //Handle the exception here to log etc.
    }
    finally {
        //Always close result set before statement
        if(rs != null) { try{ rs.close(); }catch(Throwable t){} }
        if(ps != null) { try{ ps.close(); }catch(Throwable t){} }
    }

    return list;
}