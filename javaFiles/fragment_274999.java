Connection.Response res = Jsoup.connect(SPLIT_LOGIN)
            .data("action", "account", 
                "redirect", "account_home.php?",
                "radiobutton", "old", 
                "loginemail", "XXXXX",
                "password", "XXXXX", 
                "LoginChoice", "Sign In to Secure Area")
            .method(Connection.Method.POST)
            .followRedirects(true)
            .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.110 Safari/537.36")
            .execute();