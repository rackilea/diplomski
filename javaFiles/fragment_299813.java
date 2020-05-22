try {
        Class<?> macFontFinderClass = Class.forName("com.sun.t2k.MacFontFinder");
        Field psNameToPathMap = macFontFinderClass.getDeclaredField("psNameToPathMap");
        psNameToPathMap.setAccessible(true);
        psNameToPathMap.set(null, new HashMap<String, String>());
    } catch (Exception e) {
        // ignore
    }