ProcessBuilder builder = new ProcessBuilder("ant", "-f", "/path/to/build.xml", "searchDirectories");
Process process = builder.start();

try (BufferedReader out = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
    out.lines().collect(Collectors.toList()).forEach(System.out::println);
}