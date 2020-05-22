InputStream stream = new FileInputStream("C:\\Thumbs.db");
POIFSFileSystem fs = new POIFSFileSystem(stream);
DirectoryEntry root = fs.getRoot();
Entry entry = root.getEntry("2");
DocumentInputStream is = fs.createDocumentInputStream(entry.getName());

//Added to read the header lines and fix the ImageFormatException
int header_len = is.read();
for (int i = 1; i < header_len; i++) {
        is.read();
}

JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(is);
JPEGDecodeParam param = JPEGCodec.getDefaultJPEGEncodeParam(4,JPEGDecodeParam.COLOR_ID_RGBA);
decoder.setJPEGDecodeParam(param);
BufferedImage originalBufferedImage = decoder.decodeAsBufferedImage();