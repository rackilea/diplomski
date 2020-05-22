XMLDocument document = new XMLDocument();
for (File f : files) {
    document.addElement( new XML("file")
        .addXMLAttribute("fileName", file.getName())
        .addXMLAttribute("fileType", file.getType())
      )
    );
}