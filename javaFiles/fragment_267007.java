String word = "\u6B32\u8ECE\u4F7F";

 PreparedStatement pstmt = pstmt = conn.prepareStatement("INSERT INTO MY_TABLE(WORDS) VALUES(?)");
 pstmt.setString(1, word);

 pstmt.execute();
 pstmt.close();