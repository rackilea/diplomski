public void getImages() throws Exception {

    ObjectMapper objectMapper = new ObjectMapper();
    JsonFactory jf = objectMapper.getFactory();
    JsonGenerator jg = f.createGenerator(new File("c:\\images.json"), JsonEncoding.UTF8);

    try {
        Class.forName(DRIVERNAME);
        conn = DriverManager.getConnection(URL, USER, PASS);

        Statement s = connection.createStatement();
        ResultSet r = s.executeQuery("select * from images");

        jg.writeFieldName("images");
        jg.writeStartArray();

        while (r.next()) {
           jg.writeBinary(r.getBinaryStream("IMAGEM"), -1);
           in.close();
        }

        jg.writeEndArray(); 
        jg.writeEndObject(); 
        jg.close();

    } catch (SQLException e) {
        //use the exceptions
    }
}