boolean isDownloadNeeded(URL url,
                         Path cachedFile)
throws IOException {

    if (Files.notExists(cachedFile)) {
        return true;
    }

    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("HEAD");
    long serverTimestamp = conn.getLastModified();

    long fileTimestamp = Files.getLastModifiedTime(cachedFile).toMillis();

    return (serverTimestamp == 0 || fileTimestamp < serverTimestamp);
}