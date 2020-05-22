try
{
   ExcelTransformer transformer = new ExcelTransformer();
   // template file name, destination file name, beans
   transformer.transform("Content.xls", "Populated.xls", beans);
}
catch (IOException e)
{
   System.err.println("IOException caught: " + e.getMessage());
}
catch (InvalidFormatException e)
{
   System.err.println("InvalidFormatException caught: " + e.getMessage());
}