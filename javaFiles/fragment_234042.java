public String trimSeeAlso(String string) {
    int index = string.indexOf("See also >");
    if (index < 0) return string;

    return string.substring(0, index);
}