public static boolean sortArrayList(final ArrayList <Integer> data) {
    for (int i = 1; i < data.size(); i++) {
        if (data.get(i - 1) > data.get(i)) {
            return false;
        }
    }
    return true;
}