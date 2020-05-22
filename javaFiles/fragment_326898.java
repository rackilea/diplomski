File file1 = new File("C:/dir/file1.txt");
File file2 = new File("C:/dir/file2.txt");
FileInputStream fs1 = new FileInputStream(file1);
FileInputStream fs2 = new FileInputStream(file2);
Connection.Response response = Jsoup.connect("http://www.example.com")
        .data("text", "value")
        .data("file1", "filename", fs1)
        .data("file2", "filename", fs2)
        .userAgent("Mozilla")
        .method(Method.POST)
        .execute();

//Handle your response...