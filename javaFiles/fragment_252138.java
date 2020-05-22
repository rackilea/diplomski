/**
 * @return the value of the property "java.awt.headless"
 * @since 1.4
 */
private static boolean getHeadlessProperty() {
    if (headless == null) {
        java.security.AccessController.doPrivileged(
        new java.security.PrivilegedAction<Object>() {
            public Object run() {
                String nm = System.getProperty("java.awt.headless");

                if (nm == null) {
                    /* No need to ask for DISPLAY when run in a browser */
                    if (System.getProperty("javaplugin.version") != null) {
                        headless = defaultHeadless = Boolean.FALSE;
                    } else {
                        String osName = System.getProperty("os.name");
                        if (osName.contains("OS X") && "sun.awt.HToolkit".equals(
                                System.getProperty("awt.toolkit")))
                        {
                            headless = defaultHeadless = Boolean.TRUE;
                        } else {
                            headless = defaultHeadless =
                                Boolean.valueOf(("Linux".equals(osName) ||
                                                 "SunOS".equals(osName) ||
                                                 "FreeBSD".equals(osName) ||
                                                 "NetBSD".equals(osName) ||
                                                 "OpenBSD".equals(osName)) &&
                                                 (System.getenv("DISPLAY") == null));
                        }
                    }
               } else if (nm.equals("true")) {
                    headless = Boolean.TRUE;
                } else {
                    headless = Boolean.FALSE;
                }
                return null;
            }
            }
        );
    }
    return headless.booleanValue();
}