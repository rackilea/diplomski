public static Charset getMyCustomCharset() throws java.nio.charset.UnsupportedCharsetException {
    Charset customCharset = null;
    try {
        // This will fail if running in web container because
        // the JDK loads charsets using the system class loader in the servlet
        // engine (e.g. Tomcat) so unless the JAR is available on the engine's
        // classpath then the charset will not be visible to the webapp.
        // The solution is to load the charset "manually" as below.
        customCharset = Charset.forName(CHARSET_NAME);
    } catch (Exception ex) {
        // Try to load the charset manually using ServiceLoader concept
        for (CharsetProvider charsetProvider : ServiceLoader.load(com.acme.CustomCharsetProvider.class)) {
            customCharset  = charsetProvider.charsetForName(CHARSET_NAME);
            if (customCharset != null) {
                break;
            }
        }
        // Make a final attempt. This time directly, i.e. without the use of
        // the ServiceLoader.
        if (customCharset == null) {
            com.acme.CustomCharsetProvider p = new com.acme.CustomCharsetProvider();
            customCharset = p.charsetForName(CHARSET_NAME);
        }
    }
    if (customCharset == null) {
        throw new java.nio.charset.UnsupportedCharsetException("Unknown charset : " + CHARSET_NAME);
    }
    return customCharset;
}