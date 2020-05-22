public void downloadResource() {
    try {
        URL obj = new URL("http://www.example.com/docs/resource1.html");
    }
    catch (MalformedURLException exception) {
        // You could re-throw the exception as a runtime exception which doesn't
        // need to be caught.
        throw new RuntimeException(exception);
    } 
}