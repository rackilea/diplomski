String batch = "(";
for (int i = 0; i < identities.length;i++) {
    if (i < identities.length() - 1) 
        batch += "?, ";
    else 
        batch += "?)"
}

String sql =  "SELECT * FROM cgm_counters WHERE id in " + batch;
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()) {
    double net_ppe  = rs.getDouble("spend");
    System.out.println("The value of the netppe :"+net_ppe);
}