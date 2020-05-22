NPOIFSFileSystem fs = new NPOIFSFileSytem(file);
WordExtractor extractor = new WordExtractor(fs.getRoot());

for(String rawText : extractor.getParagraphText()) {
String text = extractor.stripFields(rawText);
System.out.println(text);
}