// Save an image from server to physical location
String destinationFile = "C:\\Program Files (x86)\\openbravopos-2.30.2\\image1.jpg";

// This will call a function which will save an image on your given Location
saveImage(image, destinationFile);

// You don't need to call procedure here just pass this query
PreparedStatement pstmt = con.prepareStatement("UPDATE PRODUCTS SET IMAGE = ? WHERE ID = ?");

// Location of image with it's name
File file = new File("Location\\image1.jpg");
FileInputStream in = new FileInputStream(file);
try
{
    pstmt.setBinaryStream(1, in, (int) file.length());
    pstmt.setString(2, id);
    pstmt.executeUpdate();
}
catch (Exception ee)
{
    System.out.println("Exception is:- " + ee);
}