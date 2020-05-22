public boolean hasDuplicates(String name, Class type) {
    for (Entry entry : allEntries) {
        if (type.isInstance(entry) && name.equalsIgnoreCase(entry.getName())) {
            return true;
        }
    }
    return false;
}