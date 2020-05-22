public static String wrapText(String text, String cssClass) {
    if (text == null) {
        throw new IllegalArgumentException("Text to wrap is null");
    }
    if (cssClass == null) {
        cssClass = "";
    }
    return "<span class=\"" + cssClass + "\">" + text + "</span>";
}

public String getShortDescription() {
    if (isOption1()) {
        return "Option " + wrapText("1 heading","heading");
    }
    ...
}