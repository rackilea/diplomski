public void trimStringArray(String[] strArray) {
    Preconditions.checkNotNull(strArray);
    for(int i = 0; i < strArray.length; i++) {
        strArray[i] = trimString(strArray[i]);
    }
}