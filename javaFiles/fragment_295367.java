String fileName = "C:\\new_file.xlsm";

try {

    Workbook workbook;
    workbook = new XSSFWorkbook(
        OPCPackage.open("resources/template_with_macro.xlsm")
    );

    //DO STUF WITH WORKBOOK

    FileOutputStream out = new FileOutputStream(new File(fileName));
    workbook.write(out);
    out.close();
    System.out.println("xlsm created successfully..");

} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (InvalidFormatException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}