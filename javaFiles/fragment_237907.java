boolean contains(ArrayList<Second> list, String name) {
    for (Second item : list) {
        if (item.getName().equals(name)) {
            return true;
        }
    }
    return false;
}