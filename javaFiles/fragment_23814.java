public static void main(String[] args) {
    Reflections reflections = new Reflections(new ConfigurationBuilder()
    .setUrls(ClasspathHelper.forPackage("your.test.more"))
    .setScanners(new ResourcesScanner()));

    Set<String> textFiles = reflections.getResources(Pattern.compile(".*\\.txt"));

    for (String file : textFiles){
        System.out.println(file);
    }
}