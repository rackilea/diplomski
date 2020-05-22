Set<File> notExistingFiles = Arrays.stream(args)
    .map(File::new).filter(file -> !file.isFile()).collect(Collectors.toSet());

if(!notExistingFiles.isEmpty()) {
    notExistingFiles.forEach(file -> System.out.printf("File %s does not exist%n", file));
    System.exit(1);
}