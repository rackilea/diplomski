private static void purge(File dir, long ttl) {
    long minTime = System.currentTimeMillis()-ttl;
    for (File file: dir.listFiles()) {
        if (file.lastModified() < minTime) {
            file.delete();
        }
    }
}