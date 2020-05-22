public void load(InputStream inStream) throws IOException {
    this.inStream = inStream;
    this.properties.load(this.inStream);
    this.keys = this.properties.propertyNames();
    inStream.close();
}