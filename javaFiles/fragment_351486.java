ResultSet rs = dbmd.getSchemas();
ArrayList<String> dbs = new ArrayList<>();
while(rs.next()) { 
    dbs.add(rs.getString("TABLE_SCHEM"));
}
for(String s : dbs) {
    System.out.println(s);
}