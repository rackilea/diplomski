public class Handler extends URLStreamHandler {

@Override
protected URLConnection openConnection(URL u) throws IOException {
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    final URL resourceUrl = resolver.getResource(u.getPath()).getURL();
    if (resourceUrl == null) {
        throw new IOException(String.format("File %s not found on the classpath", u.getFile()));
    }
    return resourceUrl.openConnection();
}
}