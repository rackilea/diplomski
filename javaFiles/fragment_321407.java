final File file_to_delete = new File("[path_to_the_file]/your_file");
    if (file_to_delete.exists()) {
        try {
            delete(file_to_delete);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }