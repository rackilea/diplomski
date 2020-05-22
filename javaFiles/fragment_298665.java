Writer pw = new BufferedWriter(new PrintWriter(new File("c:\\test_chunkSpace.xml")));
pw.write("<?xml version='1.0' encoding='UTF-8'?>");
String t;
while (rs.next()) {
    t = rs.getString("xmltest");
    pw.write(t);
}