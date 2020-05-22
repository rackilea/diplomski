try {
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Michel's Muziek Magazijn.accdb");

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM mmm WHERE "+combo+" = '"+text+"'");
        StringBuilder strBuilder = new StringBuilder();

    while (rs.next()) {
            strBuilder.append( rs.getString(2) + "\t \t" + rs.getString(3)+ "\t \t" + rs.getString(4));
            strBuilder.append("\n");
        }
    jTextArea1.setText(strBuilder.toString());
        rs.close();

    } catch (SQLException e) {
        System.out.println(e);
    }