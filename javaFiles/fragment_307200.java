public boolean hasClass(WebElement element) {
    String classes = element.getAttribute("class");
    for (String c : classes.split(" ")) {
        if (c.equals(theClassYouAreSearching)) {
            return true;
        }
    }

    return false;
}