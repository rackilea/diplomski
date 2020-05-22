final File watched = new File("[path of directory to watch]");
long lastModified = watched.lastModified();
while(true) {
    if (watched.lastModified() > lastModified) {
        // Change happened in the directory do what you want.
    }
    Thread.sleep(2000); // 2 second interval
}