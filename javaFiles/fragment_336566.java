public boolean containsText(String key) {
    // your choice whether to use equals or equalsIgnoreCase
    return key.equalsIgnoreCase(title) 
            || key.equalsIgnoreCase(publisher) 
            || key.equalsIgnoreCase(author)
            || key.equalsIgnoreCase(isbn);
}