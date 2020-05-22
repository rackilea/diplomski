File file = new File("data/pattern.txt");
    Pattern pat = Pattern.compile("subclass \"Pool1\" 11:22:33:44:55:66 \\{\\s*dynamic;\\s*\\}");
    String content = Files.lines(file.toPath()).collect(Collectors.joining("\n"));
    Matcher m = pat.matcher(content);
    while (m.find()) {
        System.out.printf("found at %d-%d%n", m.start(), m.end());
    }