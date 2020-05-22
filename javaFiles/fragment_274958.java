Connection.Response response = Jsoup.connect("http://www.myameego.com/index2.php?do=login")
        .method(Connection.Method.GET)
        .execute();

Document page = Jsoup.connect("http://www.myameego.com/index2.php?do=login")
        .data("user", "login")
        .data("pass", "password")
        .data("clientID", "123456")
        .cookies(response.cookies())
        .post();