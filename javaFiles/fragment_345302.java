public int compareTo(final Book theOther) {
    int result = myTitle.compareTo(theOther.myTitle);
    if (result == 0) {
        result = myAuthors.get(0).compareTo(theOther.myAuthors.get(0));
    }
    return result;
}