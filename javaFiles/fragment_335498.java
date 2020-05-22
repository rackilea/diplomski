String sql1 = "LOAD DATA LOCAL INFILE '";
String sql2 = "' INTO TABLE mytable";

Statement s = con.createStatement();    // use a regular statement
for (String filename : filenames) {
    String query = sql1 + filename + sql2
    s.addBatch(query);
}

s.executeBatch();
s.commit();