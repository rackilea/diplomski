public static boolean ifContains(ArrayList<String> list, String name) {
    for (String item : list) {
        if (item.getName().equals(name)) {
            return true;
        }
    }
    return false;
}