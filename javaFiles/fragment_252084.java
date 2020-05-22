String url = "http://www......com/....php";
File file = new File("/path/to/file.ext");

Document document = Jsoup.connect(url)
    .data("user", "user")
    .data("password", "12345")
    .data("email", "info@tutorialswindow.com")
    .data("file", file.getName(), new FileInputStream(file))
    .post();
// ...