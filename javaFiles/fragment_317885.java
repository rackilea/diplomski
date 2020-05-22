Collections.sort(folders, new Comparator<Folder>() {
    @Override
    public int compare(Folder folder1, Folder folder2) {
        String f1 = folder1.getFolderName();
        String f2 = folder2.getFolderName();
        String f1name = f1.replaceAll("\\d+\\s+(.*)", "$1");
        String f2name = f2.replaceAll("\\d+\\s+(.*)", "$1");
        if (f1name.compareTo(f2name) != 0) {
            return f1name.compareTo(f2name);
        }
        else {
            int num1 = Integer.parseInt(f1.replaceAll("(\\d+)\\b.*", "$1"));
            int num2 = Integer.parseInt(f2.replaceAll("(\\d+)\\b.*", "$1"));
            return Integer.compare(num1, num2);
        }
    }
});