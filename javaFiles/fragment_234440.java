try {
    // do something with streams
} catch (IOException e) {
    // process exception - log, wrap into your runtime, whatever you want to...
} finally {
    try {
        stream.close();
    } catch (IOException e) { 
        // error - log it at least
    } 
}