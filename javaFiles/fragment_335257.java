public StreamedContent getFile() {
    InputStream stream = new ByteArrayInputStream( mytext.getBytes() );
    StreamedContent file = new DefaultStreamedContent(stream, "xml", "yourfile.xml");
    return file;
}

public String getMytext() {
    return mytext;
}

public void setMytext(String mytext) {
    this.mytext = mytext;
}