boolean sucess = false;
while(!success) {
    try {
        this.file = new LftFile(child.toFile(), kind != ENTRY_CREATE);
        sucess = true;
        // ADD TO FTP method
    } catch (IOException e) { // or a more explicit exception rather than a generic IOException
        Thread.sleep(1000); // Wait for a second
        sucess = false;
    }
}