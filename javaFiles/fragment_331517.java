static String trimZeros(String str) {
    int pos = str.indexOf(0);
    return pos == -1 ? str : str.substring(0, pos);
}

usernameString = trimZeros(usernameString);
passwordString = trimZeros(passwordString);