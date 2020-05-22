// Copying Files//
    } else if (!dest.exists()) {
        // if file, then copy it
        // Use bytes stream to support all file types
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dest);