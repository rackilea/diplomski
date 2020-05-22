String url = "https://users.premierleague.com/PremierUser/j_spring_security_check";

        Response res = Jsoup
                .connect(url)
                .followRedirects(false)
                .timeout(2_000)
                .data("j_username", "<USER>")
                .data("j_password", "<PASSWORD>")
                .method(Method.POST)
                .execute();

        Map<String, String> loginCookies = res.cookies();

        Document doc = Jsoup.connect("http://fantasy.premierleague.com/squad-selection/")
                .cookies(loginCookies)
                .get();