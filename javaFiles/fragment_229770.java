List<UrlObject> URLs = new ArrayList<>();
URLS.add(new URLObject("url here", <index here>));

URLs.parallelStream().forEach(url-> {
  // code here url.getUrl() and url.getIndex()
});