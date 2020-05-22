public boolean isDescendentOf(SomeClass child, String parentName) {
    SomeClass parent = map.get(child.parent);
    if (parent == null) {
        throw new RuntimeException("Warning: parent doesn't exist!");
    }
    if (parent.id.equals(parentName)) {
        return true;
    } else {
        return isDescendentOf(parent, parentName);
    }
}