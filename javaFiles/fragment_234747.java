public class xlsFileRead {

public void readFromFile(Object input)throws IOException  {

    DataHandler handler = (DataHandler)input;
    String tempfilenm = handler.getName();
    InputStream is = handler.getInputStream();
    File tempfile =new File("c:\\tempdev\\" + tempfilenm);
    OutputStream os = new FileOutputStream(tempfile);
    byte[] buffer = new byte[1024];
    int bytesRead = 0;
    while ((bytesRead = is.read(buffer)) != -1) {
    os.write(buffer,0,bytesRead);
         }      
 Workbook w;
    try {
      w = Workbook.getWorkbook(tempfile);
      // Get the first sheet
      Sheet sheet = w.getSheet(0);
      // Loop over first 10 column and lines
      for (int i = 5; i < sheet.getRows(); i++) {
      for (int j = 0; j < sheet.getColumns(); j++) {

          Cell cell = sheet.getCell(j, i);
          CellType type = cell.getType();
          if (type == CellType.LABEL) {
            System.out.print(cell.getContents() + ";");
          }

          if (type == CellType.NUMBER) {
            System.out.print(cell.getContents() + ";");
          }

        }
      System.out.println(i);
      }
    } catch (BiffException e) {
      e.printStackTrace();
    }