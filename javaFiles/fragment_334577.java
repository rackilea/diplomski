public static void main(String[] args) {
    List<File> files = new ArrayList<File>();
    files.add(new File("test_1a.play"));
    files.add(new File("test_1AA.play"));
    files.add(new File("test_1aaa.play"));
    files.add(new File("test-_1AAAA.play"));

    Collections.sort(files, new Comparator<File>() {
        @Override
        public int compare(File o1, File o2) {
            String p1 = o1.getAbsolutePath();
            String p2 = o2.getAbsolutePath();
            return p1.compareTo(p2);
        }
    });

    System.out.println(files);
}