public Set<String> readFile() {
    Set<String> setOfEmails = new HashSet<String>();

    ClassPathResource cl = new ClassPathResource("myFile.csv");
    URL url = cl.getURL();
    try (BufferedReader br = new BufferedReader(
                             new InputStreamReader(url.openStream()))) {

        Stream<String> stream = br.lines();
        setOfEmails = stream.collect(Collectors.toSet());
    } catch (IOException e) {
        logger.error("file error " + e.getMessage());
    }
    return setOfEmails;
}