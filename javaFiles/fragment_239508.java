public static void main(String[] args) {
//.... Skipped identical lines as above 
        System.out.print("Please choose row");
        int chosenRow = input.nextInt();

        StringBuilder stringBuilder = new StringBuilder();
        XSSFRow row = sheet1.getRow(chosenRow);
        int i = 0;
        for (; i < row.getPhysicalNumberOfCells() - 1; i++) {
            if (i == 2) {
                continue;// skipping the password cell
            }
            stringBuilder.append(row.getCell(i))
                    .append(" | ");
        }
        stringBuilder.append(row.getCell(i));

        String data = stringBuilder.toString();

        System.out.println(String.format("Data from Row %d are :%s", chosenRow, data));
  //.... Skipped identical lines as above 
}