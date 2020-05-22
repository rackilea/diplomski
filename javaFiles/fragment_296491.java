while (true) {
    try {
        dummy = is.read();
        if (dummy == 9999) {}
    } catch(Exception ex) {
        ex.printStackTrace();
    }
}