private List<TemplateFile> readTemplateFiles(String nextTemplateDir, String rootTemplateDir) throws FileNotFoundException {
    return Files.walk(Paths.get(nextTemplateDir))
                .filter(path -> !path.getFileName().startsWith("."))
                .map(path -> TemplateFile.create(path.toFile(), rootTemplateDir))
                .collect(Collectors.toList());
}