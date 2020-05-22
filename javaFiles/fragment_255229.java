public class MyURLConnection extends HttpURLConnection {

    public MyURLConnection(URL arg0) {
        super(arg0);
    }

    @Override
    public void disconnect() {
    }

    @Override
    public boolean usingProxy() {
        return false;
    }

    @Override
    public void connect() throws IOException {
    }
}

public class MyURLStreamHandler extends URLStreamHandler {

    public MyURLStreamHandler() {
        super();
    }

    @Override
    protected URLConnection openConnection(URL arg0) throws IOException {
        return new MyURLConnection(arg0);
    }
}