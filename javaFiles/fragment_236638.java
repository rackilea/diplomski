protected synchronized InputStream getQueryResults(...) {
    ...
    // Indentation fixed for clarity
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
       // TODO Auto-generated catch block
       return stream;
    }
}