public class XSSRequestWrapper extends HttpServletRequestWrapper {


private byte[] rawData;
private HttpServletRequest request;
private ResettableServletInputStream servletStream;

public XSSRequestWrapper(HttpServletRequest request) {
    super(request);
    this.request = request;
    this.servletStream = new ResettableServletInputStream();
}


public void resetInputStream(byte[] newRawData) {
    servletStream.stream = new ByteArrayInputStream(newRawData);
}

@Override
public ServletInputStream getInputStream() throws IOException {
    if (rawData == null) {
        rawData = IOUtils.toByteArray(this.request.getReader());
        servletStream.stream = new ByteArrayInputStream(rawData);
    }
    return servletStream;
}

@Override
public BufferedReader getReader() throws IOException {
    if (rawData == null) {
        rawData = IOUtils.toByteArray(this.request.getReader());
        servletStream.stream = new ByteArrayInputStream(rawData);
    }
    return new BufferedReader(new InputStreamReader(servletStream));
}

private class ResettableServletInputStream extends ServletInputStream {

    private InputStream stream;

    @Override
    public int read() throws IOException {
        return stream.read();
     }
   }
 }