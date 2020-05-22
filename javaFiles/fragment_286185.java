public static List<String> getJarFileListing(String jarLocation, String filter) {
        List<String> files = new ArrayList<String>();
        if (jarLocation == null) {
            return files; // Empty.
        }

        // Lets stream the jar file 
        JarInputStream jarInputStream = null;
        try {
            jarInputStream = new JarInputStream(new FileInputStream(jarLocation));
            JarEntry jarEntry;

            // Iterate the jar entries within that jar. Then make sure it follows the
            // filter given from the user.
            do {
                jarEntry = jarInputStream.getNextJarEntry();
                if (jarEntry != null) {
                    String fileName = jarEntry.getName();

                    // The filter could be null or has a matching regular expression.
                    if (filter == null || fileName.matches(filter)) {
                        files.add(fileName);
                    }
                }
            }
            while (jarEntry != null);
            jarInputStream.close();
        }
        catch (IOException ioe) {
            throw new RuntimeException("Unable to get Jar input stream from '" + jarLocation + "'", ioe);
        }
        return files;
    }