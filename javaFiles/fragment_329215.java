public static void toImage(final Workbook workbook, final String outputFilePath) throws Exception {
    ImageOrPrintOptions imgOptions = new ImageOrPrintOptions();
    imgOptions.setImageFormat(ImageFormat.getPng());
    imgOptions.setOnlyArea(true);

    Worksheet sheet = workbook.getWorksheets().get(0);
    SheetRender sr = new SheetRender(sheet, imgOptions);

    for (int j = 0; j < sr.getPageCount(); j++) {
        sr.toImage(j, outputFilePath);
    }
}