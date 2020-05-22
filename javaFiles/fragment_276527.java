public class TestLecture {

public static void main(String[] args) throws IOException{

    List<String> mys_list= new ArrayList<String>();
    FileInputStream file = new FileInputStream(new File("test.xlsx"));

    //Get the workbook instance for XLS file 
    XSSFWorkbook workbook = new XSSFWorkbook (file);

    //Get first sheet from the workbook
    XSSFSheet ws = workbook.getSheetAt(0);

    //Get iterator to all the rows in current sheet
    Iterator<Row> rowIt = ws.iterator();


     while (rowIt.hasNext()) {

         Row row = rowIt.next();
         Iterator<Cell> cellIt = row.iterator();

         while (cellIt.hasNext()) {

             Cell cell = cellIt.next();
             int columnIndex = cell.getColumnIndex();
             switch (columnIndex) {
             case 2:

                 mys_list.add(cell.getStringCellValue());

                 break;


             }

         }


     }

     System.out.println(mys_list.size());
     for(String g :mys_list){
         System.out.println(g);
     }



}