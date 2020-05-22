public XmlWriter binary( InputStream binaryStream ) throws IOException {
    Reader reader = new InputStreamReader( 
            new Base64InputStream( binaryStream, true, base64LineLength, base64LineSeparator.getBytes( charset ) ) );
    IOUtils.copy(reader, writer);
    return this;
}