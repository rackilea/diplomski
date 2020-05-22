File file = new File(filename);
while (!file.exists()) {
    try { 
        Thread.sleep(100);
    } catch (InterruptedException ie) { /* safe to ignore */ }
}