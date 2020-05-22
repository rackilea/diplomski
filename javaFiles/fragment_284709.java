try {
        // Open the ZIP file
        FileInputStream fis = new FileInputStream(new File("/your.war"));
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));

        ZipEntry entry = null;

        while ((entry = zis.getNextEntry()) != null)
            // Get the entry name
            System.out.println(entry.getName());
    } catch (IOException e) {
    }