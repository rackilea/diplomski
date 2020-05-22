Connection connection = null;
Statement statement = null;
ResultSet rs = null;
  
try {
         
        Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(connectionURL, "sa", "sa");
        statement = connection.createStatement();
        rs = statement.executeQuery("SELECT fileName,blobFile FROM tblBlobFiles");
     
     
        if (rs.next()) {
  
String filename = rs.getString(1);
           Blob blob = rs.getBlob(2);
          InputStream is = blob.getBinaryStream();
              FileOutputStream fos = new FileOutputStream("C:\\DownloadedFiles"+ "\\" + filename);
 
int b = 0;
while ((b = is.read()) != -1)
{
    fos.write(b); 
}
        }
    } catch (IOException e) 
    {
    e.getMessage (); e.printStackTrace(); 
System.out.println(e); 
    } 
    catch (SQLException e) 
    {
    e.getMessage (); e.printStackTrace(); 
System.out.println(e); 
    }