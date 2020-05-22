String query = "INSERT INTO TimestampsStorage VALUES (?)";
PreparedStatement ps = conn.prepareStatement(query);
for (mapperValue = mapper.readLine(); 
     mapperValue != null; 
     mapperValue = mapper.readLine()) {

    i++;
    records++;
    System.out.println("Batching " + records + " records...");

    ps.setString(1, mapperValue);
    ps.addBatch();

    if (i == 100000) {
        ps.executeBatch();
        i = 0;
    }
}