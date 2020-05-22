public class BlobDataExtract {
     static ZipOutputStream zos =null;
      static String url = "jdbc:oracle:thin:@hostname:1521:SID";    
      public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url, "user", "password");     
            String sql="select Blob_Data,ORIG_NM from table";           
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();       
            byte[] docBlob = null;
            String filename = null;         
            FileOutputStream fos = new FileOutputStream("C:/Users/test.zip");     
                  zos = new ZipOutputStream(fos);
                  while (rs.next()) {               
                        docBlob = rs.getBytes("Blob_Data");   
                        filename = rs.getString("ORIG_NM");
                            try {
                                zos.putNextEntry(new ZipEntry(filename));
                                 zos.write(docBlob, 0, Blob_Data.length);    
                            }
                            catch (FileNotFoundException ex) {
                                 System.err.println("A file does not exist: " + ex);
                             } catch (IOException ex) {
                                 System.err.println("I/O error: " + ex);
                             }
                            zos.closeEntry();
                  }            

          }
}