public class Test2 {
        //Reflection in Keyword driven Framework
    /**
    * @authors Venkadesh,Selvakumar work name : Test
    **/
    static Class Class1 = ActionKeywords.class;
    static ActionKeywords Keywords = new ActionKeywords();
    public static void main(String[] args) throws Exception {

        String sPath = "C:\\Users\\mag6\\Desktop\\toolsqa.xlsx";
        ExcelUtils.setExcelFile(sPath, "Test Steps");
        Method[] methods = Class1.getDeclaredMethods();

        for (int i = 1; i <= 9; i++) {
            // This to get the value of column Action Keyword from the excel
            String sActionKeyword = ExcelUtils.getCellData(i, 3);
            for (int j = 1; j <= 9; j++) {
                if (methods[j].getName().equals(sActionKeyword)) {
                    try {

                        methods[j].invoke(Keywords);
                    } catch (Exception e) {
                    }

                    System.out.println(methods[j]);
                }

            }

        }
    }
}