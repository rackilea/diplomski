try
{
  File file = new File("Sample.pdf");
  java.awt.Desktop.getDeskTop().open(file);
  System.out.println("File opened successfully");
}catch(Exception ex)
{
  System.out.println("Error occurred: "+ex);
}