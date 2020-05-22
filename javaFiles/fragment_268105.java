List<String> lineas = new ArrayList<>();
try (BufferedReader in = Files.newBufferedReader(Paths.get("C:\\Personal\\temp\\ffffff.txt"),
                                                 Charset.forName("ISO-8859-3"))) {
    for (String s; (s = in.readLine()) != null; ) {
        lineas.add(s);
    }
}