public boolean canWrite() {
SecurityManager security = System.getSecurityManager();
if (security != null) {
    security.checkWrite(path);
}
return fs.checkAccess(this, FileSystem.ACCESS_WRITE);
}