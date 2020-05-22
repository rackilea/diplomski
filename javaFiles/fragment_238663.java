// I've guessed at the types...
public boolean isCategoryAllowed(Event evt, Iterable<String> allowedCategories) {
    for (String allowedCategory : allowedCategories) {
        if (evt.getLoggerName().startsWith(allowedCategory)) {
            return true;
        }
    }
    return false;
}