LineIterator it = FileUtils.lineIterator(theFile, "UTF-8");
try {
    while (it.hasNext()) {
        String line = it.nextLine();
        // do something with line
        // db insert
    }
} finally {
    LineIterator.closeQuietly(it);
}