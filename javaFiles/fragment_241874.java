class MyLSInput implements LSInput {

private final URI url;

public MyLSInput(URI url) {
    super();
    this.url = url;
}

@Override
public Reader getCharacterStream() {
    return null;
}

@Override
public void setCharacterStream(Reader characterStream) {

}

@Override
public InputStream getByteStream() {
    return null;
}

@Override
public void setByteStream(InputStream byteStream) {

}

@Override
public String getStringData() {
    return null;
}

@Override
public void setStringData(String stringData) {

}

@Override
public String getSystemId() {
    return url.toASCIIString();
}

@Override
public void setSystemId(String systemId) {
}

@Override
public String getPublicId() {
    return null;
}

@Override
public void setPublicId(String publicId) {
}

@Override
public String getBaseURI() {
    return null;
}

@Override
public void setBaseURI(String baseURI) {

}

@Override
public String getEncoding() {
    return null;
}

@Override
public void setEncoding(String encoding) {

}

@Override
public boolean getCertifiedText() {
    return false;
}

@Override
public void setCertifiedText(boolean certifiedText) {

}

}