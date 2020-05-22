if (!entry.isDirectory()) {
            // if the entry is a file, extracts it
            new File(filePath).getParentFile().mkdirs();
            extractFile(zipIn, filePath);
            System.out.println(filePath);
        } else {
            // if the entry is a directory, make the directory
            File dir = new File(filePath);
            System.out.println(filePath);
            dir.mkdirs();
        }