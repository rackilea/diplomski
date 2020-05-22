List<File> files = Arrays.asList(new File("/your/directory").listFiles());

List<String> fileNames = new LinkedList<>();
for (File file : files) {
    fileNames.add(somePrefix + file.getName());
}

request.setAttribute("fileNames", fileNames);