public static void main(String[] args) throws SQLException, Exception {
        Connection con = ConnectionDefinition.getOracleConnection(); //my oracle connection
        String q1 = "select object_name from user_objects";      
        PreparedStatement ps = con.prepareCall(q1);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            ResultSet rs2 = ps.executeQuery(q1);
            if(rs.isClosed()){
                System.err.println("FRIST RS IS CLOSED");
            }
        }     
        con.close();
    }