public void writeBackwards(String str) {
    // This is the negation of the stop condition, so the stop condition
    // is when the string is empty, in which case this function will do
    // nothing:
    if (!str.isEmpty()) {
        char firstCharacter = str.getFirstCharacter();
        str = str.removeFirstCharacter();
        writeBackwards(str); // the recursive call
        // The following operation will be pending, waiting for the
        // recursive call to be resolved first:
        writeCharacter(firstCharacter);
    }
}