//with awt
DataFlavor[] availableDataFlavors = Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
System.out.println("Awt detected flavors : "+availableDataFlavors.length);
for (DataFlavor f : availableDataFlavors) {
    System.out.println(f);
}

//with JavaFX (called from JavaFX thread, eg start method in a javaFX Application
Set<DataFormat> contentTypes = Clipboard.getSystemClipboard().getContentTypes();
System.out.println("JavaFX detected flavors : " + contentTypes.size());
for (DataFormat s : contentTypes) {
        System.out.println(s);
}

//let's attempt to extract bytes from the clipboard containing data from the game editor
// (note : some types will be automatically mapped to Java classes, and unknown types to a ByteBuffer)
// another reproducable example is type "Drawing Format" with a Rectangle shape copied from LibreOffice Draw 4.2
DataFormat df = DataFormat.lookupMimeType("application/spark editor");
if (df != null) {
    Object content = Clipboard.getSystemClipboard().getContent(df);
    if (content instanceof ByteBuffer) {
        ByteBuffer buffer = (ByteBuffer) content;
        System.err.println(new String(buffer.array(), "UTF-8"));
    } else
        System.err.println(content);
}