URL aURL = new URL("http://example.com:80/docs/books/tutorial"
        + "/index.html?name=networking#DOWNLOADING");

String path = aURL.getPath();
String parent = Paths.get(path).getParent().toString();

System.out.println(parent);// \docs\books\tutorial