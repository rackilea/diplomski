List<String> fileNames = new ArrayList<String>();
for (File file : listOfFiles) {
    if (file.isFile()) {
        fileNames.add(file.getName());
    } else if (file.isDirectory()) {
        // handle directory
    }
}