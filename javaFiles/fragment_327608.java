public void download() throws IOException {
    // Open connection on URL object
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    // Check response code (always do this first)
    int responseCode = connection.getResponseCode();
    System.out.println("response code: " + responseCode);
    if (responseCode == HttpURLConnection.HTTP_OK) {
        // Open input stream from connection
        BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
        // Open output stream for file writing
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("cat.jpg"));

        int totalBytesRead = 0;
        //int percentCompleted = 0;
        int i = -1;
        while ((i = in.read()) != -1) {
            out.write(i);
            totalBytesRead++;

            int old = percentCompleted;
            percentCompleted = (int) (((double) totalBytesRead / (double) connection.getContentLength()) * 100.0);
            pcs.firePropertyChange("downloading", old, percentCompleted);

            System.out.println(percentCompleted);  // makes download a bit slower, comment out for speed
        }

        // Close streams
        out.close();
        in.close();
    }
}