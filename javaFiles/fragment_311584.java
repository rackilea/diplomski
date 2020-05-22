public byte[] convert(XSSFSheet sheet) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try {
        sheet.getWorkbook().write(baos);
    } catch (IOException e) {
        // blah
    }
    return baos.toByteArray();
}