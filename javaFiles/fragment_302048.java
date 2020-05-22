public String extractNumber(String input) {
    Pattern p = Pattern.compile("glm=(\\d+)[@]?");
    Matcher m = p.matcher(input);
    if (m.find()) return m.group(1);
    else return null;
}