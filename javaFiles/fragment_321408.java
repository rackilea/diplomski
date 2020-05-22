public static void delete(File file) throws IOException {

    if (file.isDirectory()) {
        if (file.list().length == 0) {
            file.delete();
        } else {
            final String[] files = file.list();

            for (String temp : files) {
                final File fileDelete = new File(file, temp);
                delete(fileDelete);
            }
            if (file.list().length == 0) {
                file.delete();
            }
        }
    } else {
        file.delete();
    }
}