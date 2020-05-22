public boolean btnColor(char c, boolean b) {
    if (hm.getHiddenWordUpdated().contains(String.valueOf(c))) {
        return true; // this will return in case of your condition is true
    }
    return false; // this will return otherwise.
}