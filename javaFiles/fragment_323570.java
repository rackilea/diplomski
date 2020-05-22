URL url = getClass().getResource("/path/to/image.png");
  final String html
        = "<html><body>"
        + "<img src='"
        + url
        + "' width=150 height=150> ";