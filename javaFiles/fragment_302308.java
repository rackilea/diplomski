private String url;

@Factory(dataProvider = "urls", dataProviderClass = URLProvider.class)
public EndToEndTest(String url) {
  this.url = url;
}