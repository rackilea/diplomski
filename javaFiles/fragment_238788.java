public static void main(String[] args) {

        String str1 = "c:/file/test.xlsx";
        try {


            //open file
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File(str1)));
            System.out.println(wb.getSheetAt(0).getRow(1).getCell(0).getDateCellValue().toString());

            //FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

            XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);

            //save file
            FileOutputStream out = new FileOutputStream(str1);
            wb.write(out);
            out.close();

            wb = new XSSFWorkbook(new FileInputStream(new File(str1)));
            System.out.println(wb.getSheetAt(0).getRow(1).getCell(0).getDateCellValue().toString());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }