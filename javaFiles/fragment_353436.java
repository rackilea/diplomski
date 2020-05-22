File tempDir = new File(System.getProperty("java.io.tempdir"));
File receiptFile = File.createTempFile("FredReceipt", "html", tempDir);
receiptFile.deleteOnExit();
// fill the file with mark-up
// ...
// end filling
editorPane.setPage(receiptFile.toURI().toURL());