PreparedStatement pstmt = conn.prepareStatement("insert into clob_table (id, clob_colum) values (?,?)";
String clobData = "....";
Reader reader = new StringReader(clobData);
pstmt.setInt(1, 42);
pstmt.setCharacterStream(2, reader, clobData.length());
pstmt.executeUpdate();