public static Class<?> bundleClassForName(Bundle bundle, String name) throws ClassNotFoundException {
    int length = name.length();
    if (length > 0 && name.charAt(0) == '[') {
        int pos = 1;
        while (pos < length && name.charAt(pos) == '[') {
            pos++;
        }

        if (pos < name.length()) {
            if (name.charAt(pos) != 'L') {
                return Class.forName(name);
            }

            if (name.charAt(length - 1) == ';') {
                String componentName = name.substring(pos + 1, length - 1);
                Class<?> klass = bundle.loadClass(componentName);
                ClassLoader loader = klass.getClassLoader();
                return Class.forName(name, false, loader);
            }
        }
    }

    return bundle.loadClass(name);
}