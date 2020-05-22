File files[] = new File("/path/to/files").listFiles();
List<File> selection = null;
List<File> fileList = new ArrayList<File>(Arrays.asList(files));
Collections.shuffle(fileList);
selection = fileList.subList(0, Math.min(1000, fileList.size()));

for (File file : selection) {
    System.out.println(file);
}