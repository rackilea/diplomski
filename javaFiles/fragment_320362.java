Connection.Response res1 = Jsoup.connect("https://url.publishedprices.co.il/login").method(Method.GET).execute();
        Document welcomePage = res1.parse();
        Map welcomCookies = res1.cookies();
        Element inputHidden = welcomePage.getElementById("csrftoken");


        String securityTokenKey = inputHidden.attr("name");
        String securityTokenValue = inputHidden.attr("value");

        Connection.Response res2 = Jsoup.connect("https://url.publishedprices.co.il/login/user")
                .header("Content-Type","application/x-www-form-urlencoded;charset=UTF-8")
                .data("username", "readonly")
                .data("password", "123456")
                .data(securityTokenKey, securityTokenValue)
                .cookies(welcomCookies)
                .method(Method.POST)
                .execute();

        System.out.println(res2.body());