public int insertJSONtoDB() throws Exception {
    int status = 0;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "root");
        PreparedStatement preparedStatement = con.prepareStatement("insert into  employee values ( ?, ?, ? )");
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("c.\\employee.json")); 
        JSONObject jsonObject = (JSONObject) obj;

        String id = (String) jsonObject.get("id"); // from JSON tag
        preparedStatement.setString(1, id); // to the Database table

        String name = (String) itemize.get("name");
        preparedStatement.setString(2, name);

        String address = (String) itemize.get("address");
        preparedStatement.setString(3, address);

        status = preparedStatement.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (con != null) {
                con.close();
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    return status;
}