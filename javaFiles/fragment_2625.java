public Phrase createPhrase(String path) throws IOException {
    Phrase p = new Phrase();
    BufferedReader in = new BufferedReader(
        new InputStreamReader(new FileInputStream(path), "UTF8"));
    String str;
    while ((str = in.readLine()) != null) {
        p.add(str);
    }
    in.close();
    return p;
}