List<Path> files = new ArrayList<>();
try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
    for(Path p : stream) {
        files.add(p);
    }
}

Collections.sort(files, new Comparator<Path>() {
    public int compare(Path o1, Path o2) {
        try {
            return Files.getLastModifiedTime(o1).compareTo(Files.getLastModifiedTime(o2));
        } catch (IOException e) {
            // handle exception
        }
    }
});