public Child(String url) {
    this(new URL(url));
}

// Or public, of course
private Child(URL url) {
    super(url.getHost(), url.getPath(), url.getPort());
}