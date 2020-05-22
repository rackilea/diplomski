Path path = new File(
        Main.class.getResource("fxml/iKnowThisFileExists.txt").toURI()
).getParentFile().toPath();
List<String> cssFileNames2 = Files.walk(path)
                                 .map(Path::getFileName)
                                 .map(Path::toString)
                                 .filter(n -> n.endsWith(".css"))
                                 .collect(Collectors.toList());