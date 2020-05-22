PackageManager pm = getPackageManager();
List<PackageInfo> packages = pm.getInstalledPackages();
for(PackageInfo package : packages) {
    if(package.packageName.startWith("com.myapp.extension.") {
        // found an extension package!
        handleExtensionPackage(package);
    }
}