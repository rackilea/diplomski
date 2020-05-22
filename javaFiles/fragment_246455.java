try (Scanner s = new Scanner(getClass().getClassLoader().getResourceAsStream("batTemplate.txt"), "UTF-8")) {
    bat = s.useDelimiter("\\Z").next();
    if (s.ioException() != null) {
        throw s.ioException();
    }
}