final static String WORKSPACE = "C:/testfolder/";

private static void createOutputFolder(String outputFolderName) {
    File outputDirectory = new File(WORKSPACE + outputFolderName);

    if (!outputDirectory.exists()) {
        try {
            outputDirectory.mkdir();
        } catch (Exception e) {
        }
    }
}

private static void exlCreator() {

    String outputFolder = "output/";
    String fileName, fileNameWPathInput;
    int serialNumber = 1;
    createOutputFolder(outputFolder);

    MaxDuplicateWordCount mdc = new MaxDuplicateWordCount();
    File folder = new File(WORKSPACE);
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
        if (listOfFiles[i].isFile()) {
            fileName = listOfFiles[i].getName();
            fileNameWPathInput = WORKSPACE + fileName;
            Map<String, Integer> wordMap = mdc.getWordCount(fileNameWPathInput);
            List<Entry<String, Integer>> list = mdc.sortByValue(wordMap);
            String fileNameWPathOutput = WORKSPACE + outputFolder +
                    fileName.substring(0, fileName.length() - 4)
                    + "output.xls";
            try {
                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet("ResultSheet");

                HSSFRow rowhead = sheet.createRow((short) 0);
                rowhead.createCell(0).setCellValue("Serial No.");
                rowhead.createCell(1).setCellValue("Word");
                rowhead.createCell(2).setCellValue("Count");

                for (Map.Entry<String, Integer> entry : list) {
                    HSSFRow row = sheet.createRow((short) serialNumber);
                    row.createCell(0).setCellValue(serialNumber);
                    row.createCell(1).setCellValue(entry.getKey());
                    row.createCell(2).setCellValue(entry.getValue());
                    serialNumber++;
                }
                FileOutputStream fileOut = new FileOutputStream(fileNameWPathOutput);
                workbook.write(fileOut);
                fileOut.close();
                serialNumber = 1;
                System.out.println(fileNameWPathOutput + " is created");

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }


}

public static void main(String [] args) throws IOException {
    exlCreator();
}