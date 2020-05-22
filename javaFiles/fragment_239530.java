PosixFileAttributeView view =
    Files.getFileAttributeView(adb, PosixFileAttributeView.class);
if (view != null) {
    Set<PosixFilePermission> perms = view.readAttributes().permissions();
    if (perms.add(PosixFilePermission.OWNER_EXECUTE)) {
        view.setPermissions(adb, perms);
    }
}