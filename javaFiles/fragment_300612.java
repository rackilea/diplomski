BufferedReader br = new BufferedReader(new FileReader(new File("myCmrFile")));
String line = null;
int linecount = 0;
while ((line = br.readLine()) != null){
    if (linecount++ < 2) // skip the headers
        continue;
    // split the data and convert to integers
    String[] data = line.split(",");
    Integer packetsLost = Integer.valueOf(data[10]); 
    Integer jitter = Integer.valueOf(data[11]); 
    Integer latency = Integer.valueOf(data[12]); 
    // now insert into the db, query will look something like this
    String query = "INSERT INTO myTable (numberPacketsLost, jitter, latency) VALUES(?,?,?)";
    PreparedStatement ps = connection.prepareStatment(query);
    ps.setInt(1, packetsLost);
    ps.setInt(2, jitter);
    ps.setInt(3, latency);
    ps.executeUpdate();
}