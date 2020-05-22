ArrayList<String> links = new ArrayList<>();

links.parallelStream().forEach(link -> {
  try {
    Document doc = Jsoup.connect(link).get();
    getInfo(doc);
  }catch (IOException e) {
    e.printStackTrace();
  }
});