Connection.Response res = Jsoup.connect("http://example.org")
                .data("q", username, "password", password) 
                .method(Method.GET)
                .execute();

Document doc = res.parse();
System.out.println(doc);