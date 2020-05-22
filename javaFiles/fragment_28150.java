File dir = new File("path/to/files/");

for (File file : dir.listFiles()) {
    Scanner s = new Scanner(file);
    ...
    s.close();
}