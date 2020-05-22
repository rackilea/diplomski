try {

   Workbook workbook = new XSSFWorkbook();
   Sheet sheet = workbook.createSheet("MYSheet");


   InputStream inputStream = new FileInputStream("path_to_image.jpg");

   byte[] imageBytes = IOUtils.toByteArray(inputStream);

   int pictureureIdx = workbook.addPicture(imageBytes, Workbook.PICTURE_TYPE_PNG);

   inputStream.close();

   CreationHelper helper = workbook.getCreationHelper();

   Drawing drawing = sheet.createDrawingPatriarch();

   ClientAnchor anchor = helper.createClientAnchor();

   anchor.setCol1(1);
   anchor.setRow1(2);

   drawing.createPicture(anchor, pictureureIdx);


   FileOutputStream fileOut = null;
   fileOut = new FileOutputStream("output.xlsx");
   workbook.write(fileOut);
   fileOut.close();
}catch (Exception e) {
   System.out.println(e);
}