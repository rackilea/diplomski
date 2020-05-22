public static void main(String[] args) {
    try {
        // get webcam page
        URL url = new URL("...your example URL.../webcam/campob.html");
        InputStreamReader isr = new InputStreamReader(url.openStream(), "UTF-8");
        Scanner scanner = new Scanner(isr);
        final Pattern nullDelimiter = Pattern.compile("<<<>>>");
        String html = scanner.useDelimiter(nullDelimiter).next();
        scanner.close();

        // extract image URL from HTML
        final Pattern extractPattern = Pattern.compile(
                "^var BaseURL = \"([^\"]+)\".*"
                + "^var ImageResolution = \"([^\"]+)\".*"
                + "^var File = \"([^\"]+)\"", 
                Pattern.MULTILINE|Pattern.DOTALL);
        Matcher m = extractPattern.matcher(html);
        if (!m.find()) throw new RuntimeException();
        URL imgURL = new URL(m.group(1) + m.group(3) + m.group(2));
        System.out.println("imgURL=" + imgURL);

        // read headers into buffer 
        InputStream is = imgURL.openStream();
        byte[] buffer = new byte[131072];
        int bytes = 0;
        Pattern headersPattern = Pattern.compile(
                "^Content-Length:\\s*(\\d+)\\s*$.*?^$\\r?\\n", 
                Pattern.MULTILINE|Pattern.DOTALL);
        while (bytes < buffer.length) {
            int count = is.read(buffer, bytes, buffer.length - bytes);
            if (count < 0) break;
            bytes += count;
            m = headersPattern.matcher(new String(buffer, "ASCII"));
            if (m.find()) break;
        }

        // read rest of image bytes into buffer
        int offset = m.end();
        int contentLength = Integer.parseInt(m.group(1));
        int limit = Math.min(buffer.length, offset + contentLength);
        while (bytes < limit) {
            int count = is.read(buffer, bytes, limit - bytes);
            if (count < 0) break;
            bytes += count;
        }
        is.close();
        System.out.println("bytes=" + bytes + " offset=" + offset);

        // read image from buffer (start after header)
        is = new ByteArrayInputStream(buffer);
        is.skip(offset);
        Image img = ImageIO.read(is);
        System.out.println(img);
    } catch (Exception ex) {
        ex.printStackTrace(System.err);
    }
}