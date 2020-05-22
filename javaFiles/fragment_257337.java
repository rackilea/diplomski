byte[] array; // This is your byte array containing the image
URL url = new URL("http://yourwebserver.com/image-upload-or-whatever");
HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
try {
    urlConnection.setDoOutput(true);
    urlConnection.setChunkedStreamingMode(0);

    OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
    // Now you have an output stream that is connected to the webserver that you can
    //  write the content into
    for (byte b : array) {
        // Get the ASCII character for the first and second digits of the byte
        int firstDigit = ((b >> 4) & 0xF) + '0';
        int nextDigit = (b & 0xF) + '0';
        out.write(firstDigit);
        out.write(nextDigit);
    }
    out.flush(); // ensure all data in the stream is sent
    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
    readStream(in); // Read any response
} finally {
    urlConnection.disconnect();
}