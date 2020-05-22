LoadedApk packageInfo = getPackageInfoNoCheck(
        data.info.applicationInfo, data.compatInfo);
Service service = null;
try {
    java.lang.ClassLoader cl = packageInfo.getClassLoader();
    service = (Service) cl.loadClass(data.info.name).newInstance();
} catch (Exception e) {
    if (!mInstrumentation.onException(service, e)) {
        throw new RuntimeException(
            "Unable to instantiate service " + data.info.name
            + ": " + e.toString(), e);
    }
}