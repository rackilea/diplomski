public class SeleniumTools {
    public function loadCSS(String styleDefinitions, Boolean flatImageFolder) {
        Pattern pattern;
        if(flatImageFolder) {
            pattern = Pattern.compile("url\\((?:.*?\\/)(.*?).(png|gif)\\)");
        } else {
            pattern = Pattern.compile("url\\(((?:.*?\\/).*?).(png|gif)\\)");
        }
        Matcher matcher = pattern.matcher(styleDefinitions);
        StringBuffer styleDefinitionsWithInlineImageData = new StringBuffer();
        int lastMatchEndPosition = 0;
        while(matcher.find()) {
            String filename = matcher.group(1);
            String extension = matcher.group(2);
            lastMatchEndPosition = matcher.end();
            matcher.appendReplacement(styleDefinitionsWithInlineImageData, "url(" + convertImageToBinaryData(
                        SeleniumTools.class.getResourceAsStream("/images/" + filename + "." + extension), extension) + ")");
        }
        // add all definitions from the last match until the end of the stylesheet
        styleDefinitionsWithInlineImageData.append(styleDefinitions.substring(lastMatchEndPosition));
        String script = "jQuery('<style type=\"text/css\">" + styleDefinitionsWithInlineImageData.toString() + "</style>').appendTo('html > head');";
        ((JavascriptExecutor) webDriver).executeScript(script);
    }

    private static String convertImageToBinaryData(InputStream imageInputStream, String fileExtension) {
        BufferedImage image;
        try {
            image = ImageIO.read(imageInputStream);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, fileExtension, baos);
            return "data:image/" + fileExtension + ";base64," + Base64.encode(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}