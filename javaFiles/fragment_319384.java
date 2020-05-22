// Invoked in the java.lang.Runtime class to implement load and loadLibrary.
static void loadLibrary(Class fromClass, String name,
                        boolean isAbsolute) {
    ClassLoader loader =
        (fromClass == null) ? null : fromClass.getClassLoader();
    if (sys_paths == null) {
        usr_paths = initializePath("java.library.path");
        sys_paths = initializePath("sun.boot.library.path");
    }
    if (isAbsolute) {
        if (loadLibrary0(fromClass, new File(name))) {
            return;
        }
        throw new UnsatisfiedLinkError("Can't load library: " + name);
    }
// ....