public class FooExample {

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {                                      

        String sDay = day.getText();
        String sName = name.getText();
        String sCash = cash.getText();
        String sReason = reason.getText();
        String sCourse = courses.toString();

    }  // this bracket was missing in the original code 

    public static void main(String[] args) throws IOException, WriteException {

        try {
            String fileName = "E:\\Java Workspace\\file" + day + ".xls";
            WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));
            WritableSheet sheet = workbook.createSheet(name, 0);

            Label label1 = new Label(0, 0, "A label word record");
            sheet.addCell(label1);

            jxl.write.Number number = new jxl.write.Number(0, 1, 3.1459);
            sheet.addCell(number);

            workbook.write();
            workbook.close();
        } catch(Exception ex){ // the fix
            System.out.println("Error " + ex.getMessage());
            //TODO handle Exception as you need
        }
  }
}