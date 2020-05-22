Connection.Response login = Jsoup.connect("https://www.tickld.com/signin")
                                .data("l_username", "myUsername")
                                .data("l_password", "myPassword")
                                .method(Connection.Method.POST)
                                .execute();

Document document = Jsoup.connect("http://www.tickld.com/user/chosimbaaaa")
                .cookies(login.cookies())
                .get();