private static void preloadSigar() {

        String arch = System.getProperty("os.arch");
        String libName;

        if (SystemUtils.IS_OS_WINDOWS) {
            if (arch.equalsIgnoreCase("x86")) 
                libName = "sigar-x86-winnt";
            else
                libName = "sigar-amd64-winnt";
        } else if (SystemUtils.IS_OS_MAC_OSX) {
            if (arch.startsWith("i") && arch.endsWith("86"))
                libName = "sigar-universal-macosx";
            else
                libName = "sigar-universal64-macosx";
        } else {
            throw new RuntimeException("Unrecognized platform!");

        }

        System.setProperty("org.hyperic.sigar.path", "-");    
        System.loadLibrary(libName);

      }