public static void main(String[] args) throws Exception {
    String source = "\\\"url240\\\":\\\"https:\\\\\\/\\\\\\/domain.com\\\\\\/id123456\\\\\\/files\\\\\\/video.240.mp4?extra=hash\\\",\n\\\"url360\\\":\\\"https:\\\\\\/\\\\\\/domain.com\\\\\\/id123456\\\\\\/files\\\\\\/video.360.mp4?extra=hash\\\",\n\\\"url480\\\":\\\"https:\\\\\\/\\\\\\/domain.com\\\\\\/id123456\\\\\\/files\\\\\\/video.480.mp4?extra=hash\\\",\n\\\"url720\\\":\\\"https:\\\\\\/\\\\\\/domain.com\\\\\\/id123456\\\\\\/files\\\\\\/video.720.mp4?extra=hash\\\"";
    String pattern = "\\\\\"url\\d+\\\\\":\\\\\"(.*?)\\\\\"";

    System.out.println("Source: " + source);
    System.out.println("\nPattern: " + pattern);

    List<String> sourceList = new ArrayList<String>();
    Pattern vPattern = Pattern.compile(pattern);
    Matcher videoMatcher = vPattern.matcher(source);
    while (videoMatcher.find()) {
        sourceList.add(videoMatcher.group(1));
    }

    System.out.println("\nResult:" + Arrays.toString(sourceList.toArray(new String[0])));
}