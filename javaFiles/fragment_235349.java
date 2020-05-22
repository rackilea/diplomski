String sql = "INSERT INTO sample(date, someFloat) VALUES(?, ?)";

PreparedStatement prepStatement = conn.prepareStatement(sql);
PreparedStatement prepStatement1 = conn.prepareStatement("SELECT * FROM sample");
prepStatement.setDate(1, sqlDate);
prepStatement.setFloat(2, 1.0f);