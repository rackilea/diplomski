ByteArrayOutputStream bos = new ByteArrayOutputStream();
try {
    workbook.write(bos);
} finally {
    bos.close();
}
byte[] bytes = bos.toByteArray();