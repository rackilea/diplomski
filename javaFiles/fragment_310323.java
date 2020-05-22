public static void main(String[] args) {

    Response req;
    try {
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36";

        req = Jsoup.connect("https://m.facebook.com/login/async/?refsrc=https%3A%2F%2Fm.facebook.com%2F&lwv=100")
            .userAgent(userAgent)
            .method(Method.POST).data("email", "YOUR_EMAIL").data("pass", "YOUR_PASSWORD")
            .followRedirects(true).execute();

        Document d = Jsoup.connect("https://m.facebook.com/profile.php?ref=bookmarks").userAgent(userAgent)
            .cookies(req.cookies()).get();

        System.out.println(d.body().text().toString());
    } catch (Exception e) {
        e.printStackTrace();
    }

}