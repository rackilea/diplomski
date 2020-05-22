IIOMetadata metadata = jpegReader.getImageMetadata();

IIOMetadataNode root = (IIOMetadataNode) metadata.getAsTree(metadata.getNativeMetadataFormatName());
NodeList dqt = root.getElementsByTagName("dqt");
NodeList dqtables = ((IIOMetadataNode) dqt.item(0)).getElementsByTagName("dqtable");
JPEGQTable[] qTables = new JPEGQTable[dqtables.getLength()];

for (int i = 0; i < dqtables.getLength(); i++) {
    qTables[i] = (JPEGQTable) ((IIOMetadataNode) dqtables.item(i)).getUserObject();
    System.out.println("qTables: " + qTables[i]);
}