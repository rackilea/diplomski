final Link link = new StatelessLink("linkId") {
  @Overrride
  public void onClick() {
    doSomething();

    final String url = RequestCycle.get().getUrlRenderer().renderFullUrl(Url.parse(urlFor(getClass(), getPageParameters()))) + "#rules;
    setResponsePage(new RedirectPage(url));
  }
}