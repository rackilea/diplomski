final File folder = new File("docs");
    final File[] files = folder.listFiles();
    final StringBuilder filenames = new StringBuilder();
    for(File file : files) {
        filenames.append(file.getName());
        // append separator if required
    }