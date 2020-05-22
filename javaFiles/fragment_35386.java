public static List<File> walk(final File root, final String extension) {
    final File[] list = root.listFiles();
    if (list == null) {
        return Collections.EMPTY_LIST;
    }

    final List<File> res = new ArrayList<>();
    for (final File f : list) {
        if (f.isFile() && f.getName().endsWith(extension)) {
            res.add(f);
        }
    }

    return res;
}