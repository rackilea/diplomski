TikaConfig tika = TikaConfig.getDefaultConfig();
TikaInputStream stream = TikaInputStream.get(file);
ContentHandler handler = new BodyContentHandler();
Metadata metadata = new Metadata();
tika.getParser().parse(input, handler, metadata, new ParseContext());
String text = handler.toString();