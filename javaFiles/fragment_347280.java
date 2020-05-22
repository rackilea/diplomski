System.setProperty("http.agent", "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6");
final String query = "abbreviated";
final String urlPrefix = "https://translate.google.bg/translate_a/single?client=t&sl=en&tl=tr&hl=bg&dt=at&dt=bd&dt=ex&dt=ld&dt=md&dt=qca&dt=rw&dt=rm&dt=ss&dt=t&ie=UTF-8&oe=UTF-8&source=bh&ssel=0&tsel=0&kc=1&tk=811697.665342&q=";
try (final InputStream stream = new URL(urlPrefix +  URLEncoder.encode(query, "UTF-8")).openStream()) {
    final String line = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8)).readLine();
    System.out.println(line);
}