private List<Class<?>> loadClassesInPackage(String packageName) {

    ClassLoader loader = getClassLoader();
    List<Class<?>> list = new ArrayList<Class<?>>();
    // com\.package\.subpackage(?!.*\$).*
    String regex = Pattern.quote(packageName) + "(?!.*\\$).*";

    try {
        DexFile df = new DexFile(getPackageCodePath());
        for (Enumeration<String> e = df.entries(); e.hasMoreElements(); ) {
            String s = e.nextElement();

            if (s.matches(regex)) {
                Log.d(TAG, "match: " + s);

                list.add(loader.loadClass(s));
            }

        }
    } catch (Exception e) {
        Log.w(TAG, "exception while building class list", e);
    }

    return list;
}