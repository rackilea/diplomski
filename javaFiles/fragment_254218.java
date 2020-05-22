for(int i=0;i<identities.length;i++) {
    String sql =  "SELECT * FROM cgm_counters WHERE id="+identities[i];
    ResultSet rs = stmt.executeQuery(sql);
    while(rs.next()){
        //Retrieve by column name
        double net_ppe  = rs.getDouble("spend");
        System.out.println("The value of the netppe :"+net_ppe);
    }
}