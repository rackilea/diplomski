public void prepare(IFolder folder) {
    if (!folder.exists()) {
        prepare((IFolder) folder.getParent())
        folder.create(false, false, null);
    }
}