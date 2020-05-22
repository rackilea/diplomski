Arrays.sort(files, new Comparator<File>() {
        @Override
        public int compare(final File o1, final File o2) {
            try {
                BasicFileAttributes f1Attr = Files.readAttributes(Paths.get(f1.toURI()), BasicFileAttributes.class);
                BasicFileAttributes f2Attr = Files.readAttributes(Paths.get(f2.toURI()), BasicFileAttributes.class);
                return f1Attr.creationTime().compareTo(f2Attr.creationTime());
            } catch (IOException e) {
                return 0;
            }
        }
    });