public boolean multipleStringEquals(String[] strings) {

    for (int i = 0; i < strings.length; i++) {
        for (int j = i + 1; j < strings.length; j++) {
            if (strings[i].equals(strings[j])) {
                return true;
            }
        }
    }
    return false;
}