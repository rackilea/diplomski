StringBuilder text = new StringBuilder();
try (Reader reader = new BufferedReader(
    new InputStreamReader(
        getClass().getClassLoader().getResourceAsStream("batTemplate.txt"),
        StandardCharsets.UTF_8))) {

    int c;
    while ((c = reader.read()) >= 0) {
        text.append(c);
    }
}

String bat = text.toString();