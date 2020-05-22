Connection.Response loginForm = Jsoup.connect("https://login.to/")
                .ignoreContentType(true)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                .referrer("http://www.google.com")
                .timeout(12000)
                .followRedirects(true)
                .method(Connection.Method.GET)
                .execute();

Connection.Response loginFormFilled = Jsoup.connect("https://login.to/")
            .ignoreContentType(true)
            .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
            .followRedirects(true)
            .referrer("https://login.to/")
            .data("LOGON", "user")//check the form to find field name for user name
            .data("PASSWORDS", "pass")//check the form to find field name for user password
            .cookies(loginForm.cookies())
            .method(Connection.Method.POST)
            .execute();
            int statusCode = loginFormFilled.statusCode();
            Map<String, String> cookies = loginFormFilled.cookies();