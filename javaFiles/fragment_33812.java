Path rootPath = Paths.get("/data/to-delete");
// before you copy and paste the snippet
// - read the post till the end
// - read the javadoc to understand what the code will do 
//
// a) to follow softlinks (removes the linked file too) use
// Files.walk(rootPath, FileVisitOption.FOLLOW_LINKS)
//
// b) to not follow softlinks (removes only the softlink) use
// the snippet below
try (Stream<Path> walk = Files.walk(rootPath)) {
    walk.sorted(Comparator.reverseOrder())
        .map(Path::toFile)
        .peek(System.out::println)
        .forEach(File::delete);
}