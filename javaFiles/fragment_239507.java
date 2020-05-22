public static void main(String[] args) {
    try {
        // Specify the path of file
        File path=new File("/Users/monasaad1/Desktop/emp.xlsx");

        // load file
        FileInputStream file = new FileInputStream(path);

        // load workbook
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        // Load sheet- Here we are loading first sheetonly
        XSSFSheet sheet1 = workbook.getSheetAt(0);
        // user input row & cell
        Scanner input = new Scanner(System.in);
        System.out.print("Please choose row");
        int choosenRow = input.nextInt();
        System.out.print("Please choose cell");
        int choosenCell = input.nextInt();

        String data = sheet1.getRow(choosenRow).getCell(choosenCell).toString();// may return null if the choosen row and/or cell goes beyond
        // the rows count and/or the cells count
        System.out.println(String.format("Data from Row %d and cell %d is %s", choosenRow, choosenCell, data));


    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}