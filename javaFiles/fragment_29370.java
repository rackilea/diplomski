for (int i = 0; i < wb.getSheet(0).getRows(); i++) {
        for (int j = 0; j < wb.getSheet(0).getColumns(); j++) {
            String testData = wb.getSheet(0).getCell(i, j).getContents();
            System.out.println(testData);
        }
}