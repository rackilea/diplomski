File file = new File(....);
    FileInputStream fis = new FileInputStream(file);
    HSSFWorkbook wb = new HSSFWorkbook(fis);
    HSSFSheet sheet = wb.getSheetAt(0);

    sheet.shiftRows(3, 3, -1);

    File outWB = new File(.....);
    OutputStream out = new FileOutputStream(outWB);
    wb.write(out);
    out.flush();
    out.close();