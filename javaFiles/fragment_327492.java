public static void main(String[] args)
{
  JFileChooser c = new JFileChooser();
  File dir = new File("directoryOfFile");
  final String uuid = "507f23e3-7634-42b6-8bef-df3eb87a595b";
  dir.listFiles(new FilenameFilter() {
     @Override
     public boolean accept(File dir, String name)
     {
        // checks for a filename consisting of uuid with a custom extension
        return name.startsWith(uuid + ".");
     }
  });
}