public boolean exists() {
    return doAccess(F_OK);
}

private boolean doAccess(int mode) {
    try {
        return Libcore.os.access(path, mode);
    } catch (ErrnoException errnoException) {
        return false;
    }
}