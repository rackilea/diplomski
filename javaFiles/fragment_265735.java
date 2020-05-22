FileOutputStream fos = new FileOutputStream( newFolder);
try
{
    for (File file : list)
    {
        FileInputStream inFile = new FileInputStream(file);

          while ((b = inFile.read()) != -1)
              fos.write(b);
          inFile.close();
      }
}
finally
{
    fos.close();
}