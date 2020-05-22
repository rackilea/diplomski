if (perm instanceof FilePermission) {
    if (perm.getActions().equals("read")) {
    // grant permission
    return;
    }
}