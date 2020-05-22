PreparedStatement pstmt = connection.prepareStatement(
   "insert into blob_table (id, blob_data) values (?, ?)";

File blobFile = new File("your_document.pdf");
InputStream in = new FileInputStream(blobFile);

pstmt.setInt(1, 42);
pstmt.setBinaryStream(2, in, (int)blobFile.length());
pstmt.executeUpdate();
connection.commit();