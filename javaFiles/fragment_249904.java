PreparedStatement statement= con.prepareStatement("INSERT INTO jam(name) 
     VALUES (?)");

    statement.setString(1,"Charlie Sheen");

statement.execute();