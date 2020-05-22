public class  ClassB {

public String getResult(){

        int sheetIndex=wb.getSheetIndex(wsName);
        int rowNum = "3";
            int colNum ="3";
        for(int i=1;i<rowNum;i++){
                Row Suiterow = ws.getRow(i);
                for(int j=1;i<colNum;j++){
                     op =Suiterow.getCell(j).getStringCellValue();
                System.out.println("get value:----"+op  );
                if(op.equalsIgnoreCase("Y")){
                    System.out.println("op is  "+op);
                return op;
                }
                else if (op.equalsIgnoreCase("N")) {
                    System.out.println("op is  " + op);
                    return op;
                }
                }

            }
            return op;
}