for (char c : test.toCharArray()) {
    if (str.indexOf(c) == -1) {
        return false;
    }
}
return true;