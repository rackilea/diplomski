public String getFile(String fileName) {
        String filePath = null;
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            filePath= classLoader.getResource(fileName).getPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  "file://"+filePath;
    }