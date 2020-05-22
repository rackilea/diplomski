List<String> dbNames = new ArrayList<String>(); 

while (rs.next()) {
    // Retrieve by column name
    String name = rs.getString("Database");
    if(!name.equals("information_schema") && !name.equals("mysql") && !name.equals("performance_schema") && !name.equals("sys")) {
        dbNames.add(name); 
    }
}