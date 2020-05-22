private void run() throws Exception
{
    Path rootDir = Paths.get("data");
    PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.pdf");

    Files.walk(rootDir)
         .filter(matcher::matches)
         .forEach(this::modifyPdf);
}

private void modifyPdf(Path p) {
    // Some code here...
}