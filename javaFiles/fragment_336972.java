try {
    this.url = new URL(url);
}
catch(MalformedURLException e) {
    throw new AssertionError(e);
}