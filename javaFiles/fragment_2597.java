@Override
public void checkPackageAccess(String pkg) {
    super.checkPackageAccess(pkg);
    System.out.println("checkPackageAccess.." + pkg);
    if (!accessOK()) {
        if (pkg.startsWith("my.specialpackage.path")) {
            throw new SecurityException("No access to " + pkg);
        }
    }
}