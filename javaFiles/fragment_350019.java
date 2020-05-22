try {
    File file = new File("/example/path/contract.pdf");
    byte[] array = FileUtils.readFileToByteArray(file);
    FileUtils.writeByteArrayToFile(new File("/example/path/contract2.pdf"), array);

} catch (IOException e) {
    e.printStackTrace();
}