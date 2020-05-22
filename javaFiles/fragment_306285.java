DataFormatter formatter = new DataFormatter();

    String val = null;

    for (int rowNum = 1; rowNum < sheet.getLastRowNum(); rowNum++) {
        Row r = sheet.getRow(rowNum);

        ArrayList<String> al = new ArrayList<String>();


        for (int i = 2; i+2 < r.getLastCellNum() + 1; i = i + 3) {
            Cell cell = r.getCell(i);
            val = formatter.formatCellValue(cell);
            al.add(val);
            cell = r.getCell(i+1);
            val = formatter.formatCellValue(cell);
            al.add(val);
        }

        System.out.println(al);
    }