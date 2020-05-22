File files[] = new File("/path/to/files").listFiles();
Map<Integer, File> selection = new HashMap<Integer, File>(1000);
while (selection.size() < 1000) {
    int value = (int)Math.round(Math.random() * files.length);
    if (!selection.containsKey(value)) {
        selection.put(value, files[value]);
    }
}
for (File file : selection.values()) {
    System.out.println(file);
}