public class ExcelDataConfig {

    HSSFWorkbook wb;
    HSSFSheet sheet;
    File src;

    public ExcelDataConfig(String excelPath)
    {

        src=new File(excelPath);
        try {

            FileInputStream fis=new FileInputStream(src);
            wb=new HSSFWorkbook(fis);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

public String getData(int sheetIndex,int row,int column){

        sheet=wb.getSheetAt(sheetIndex);
        String data="";//sheet.getRow(row).getCell(column).getStringCellValue();
        Row r=sheet.getRow(row);
        Cell c=r.getCell(column, Row.RETURN_BLANK_AS_NULL);

        if(c==null){
            data="";
        }
        else{
            if(r.getCell(column).getCellType()==HSSFCell.CELL_TYPE_STRING){
                data=r.getCell(column).getStringCellValue();                
            }else if (r.getCell(column).getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
                int intData=(int) r.getCell(column).getNumericCellValue();
                data=Integer.toString(intData);
            }
        }
        return data;

    }

public void writeData(int sheetIndex,int row,int column,String content,String excelPath ) throws IOException{

        sheet=wb.getSheetAt(sheetIndex);

        sheet.getRow(row).getCell(column).setCellValue(content);
        FileOutputStream fout=new FileOutputStream(src);
        wb.write(fout);

        //wb.close();

    }

}