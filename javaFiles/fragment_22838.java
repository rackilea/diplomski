String sql = "SELECT NAME FROM PERSON WHERE NAME LIKE ?";
 try (PreparedStatement pst = conn.prepareStatement(sql)) {
     // Trailing % for "starts with" behaviour
     pst.setString(1, userInput + "%");
     ...
 }