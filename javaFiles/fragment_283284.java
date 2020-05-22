InputStream stream = new MyInputStream(...);
try {
    // ... use stream
} catch(IOException e) {
   // handle exception
} finally {
    try {
        if(stream != null) {
            stream.close();
        }
    } catch(IOException e) {
        // handle yet another possible exception
    }
}