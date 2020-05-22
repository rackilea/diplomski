CookieHandler.setDefault(new CookieManager());

    Connection.Response loginForm = Jsoup.connect(url)
            .method(Connection.Method.GET)
            .userAgent(USER_AGENT).execute();

    Document tok = loginForm.parse();
    Element e = tok.select("input[name=csrf_token]").first();
    String appToken = e.attr("value");
    System.out.println(appToken);
    Connection.Response login = Jsoup.connect(url)
                .data("email", usr)
                .data("password", psw)
                .data("csrf_token", appToken)
                .userAgent(USER_AGENT)
                .header("Host", "dashboard.ngrok.com")
                .header("Origin", "https://dashboard.ngrok.com")
                .referrer(url)
                .cookies(loginForm.cookies())
                .method(Method.POST)
                .execute();