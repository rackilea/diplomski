private static final Pattern DATA_URL_PATTERN = Pattern.compile("^data:image/(.+?);base64,\\s*", Pattern.CASE_INSENSITIVE);

    static void handleImgSrc(String path) {
        if (path.startsWith("data:")) {
            final Matcher m = DATA_URL_PATTERN.matcher(path);
            if (m.find()) {
                String imageType = m.group(1);
                String base64 = path.substring(m.end());
                // decodeImage(imageType, base64);
            } else {
                // some logging
            }
        } else {
            // downloadImage(path);
        }
    }