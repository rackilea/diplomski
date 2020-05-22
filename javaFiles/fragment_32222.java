public class MainCreator {

    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(new File("workbook.xls"));
        Workbook wb = new HSSFWorkbook(file);
        Sheet sh = wb.getSheetAt(0);
        int lastRownum = sh.getLastRowNum();
        double summ = 0;
        double sub = 0;

        for (int i = 0; i < lastRownum + 1; i++) {
            Row row = sh.getRow(i);

            Cell cell1 = row.getCell(1);
            Cell cell2 = row.getCell(2);

            if (cell1 != null && cell2 != null) {
                String cellValue1 = cell1.getStringCellValue();
                String cellValue2 = cell2.getStringCellValue();

                String stringNumber = cellValue2.split("=")[1].trim();
                if (cellValue1.contains("ADD")) {
                    if (cellValue2.split("=")[1].trim().contains("PATH DOES NOT EXIST")) {
                        System.out.println("Path Does Not Exist");
                    } else {
                        System.out.println(cellValue1 + "/" + stringNumber);
                        summ = getSumm(summ, stringNumber);
                    }

                } else if (cellValue1.contains("SUB")) {
                    if (cellValue2.split("=")[1].trim().contains("PATH DOES NOT EXIST")) {
                        System.out.println("Path Does Not Exist");
                    } else {
                        System.out.println(cellValue1 + "/" + stringNumber);
                        sub = getSubstraction(sub, stringNumber);
                    }
                } else {
                    System.out.println("Smt wrong");
                }
            }
        }
        System.out.println("Summ = " + summ);
        System.out.println("Sub = " + sub);
    }

    private static double getSubstraction(double main, String your) {
        if (your.contains("-")) {
            return main + Double.parseDouble(your.replace("-", ""));
        } else if (your.contains("+")) {
            return main - Double.parseDouble(your.replace("+", ""));
        } else {
            return main - Double.parseDouble(your);
        }
    }

    private static double getSumm(double main, String your) {
        if (your.contains("-")) {
            return main - Double.parseDouble(your.replace("-", ""));
        } else if (your.contains("+")) {
            return main + Double.parseDouble(your.replace("+", ""));
        } else {
            return main + Double.parseDouble(your);
        }
    }
}