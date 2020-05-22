protected synchronized InputStream getQueryResults(...) {
    ...
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
       // TODO Auto-generated catch block
    }
    return stream;
}