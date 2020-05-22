public String returnFailedImages() {
    StringBuilder result = new StringBuilder();
    for(int i = 0;i < failedScreenshotImages.size(); i++) {
        result.append("<img src='" + failedScreenshotImages.get(i) + "'" + ">" + "</br>");
    }
    return result.toString();
}