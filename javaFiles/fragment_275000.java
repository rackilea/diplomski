Connection.Response res2 = Jsoup.connect("http://www.streetinsider.com/login_duplicate.php")
            .data("ok", "End Prior Session")
            .method(Connection.Method.POST)
            .cookies(res.cookies())
            .followRedirects(true)
            .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.110 Safari/537.36")
            .execute();