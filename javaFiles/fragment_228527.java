final byte[] data = ByteStreams.toByteArray(istream);
pdfs.add(data);
final PdfReader reader = new PdfReader(data);
final PdfDictionary pageDictionary = reader.getPageN(36);
final PdfArray annotations = pageDictionary.getAsArray(PdfName.ANNOTS);
if (annotations != null && annotations.size() != 0) {
    [...]
}
new PdfStamper(reader, new FileOutputStream(dir + name + "-new.pdf")).close();