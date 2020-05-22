Response initResponse = Jsoup.connect("http://moj.tvz.hr").execute();
        Document doc = initResponse.parse();
        String tvz = doc.select("input[name=TVZ]").attr("value");
        Map<String, String> cookies = initResponse.cookies();

        Response res = Jsoup.connect("https://moj.tvz.hr").data("login", "gost", "passwd", "gost")//
                .data("TVZ", tvz)//
                .cookies(cookies)//
                .method(Method.POST).execute();
        System.out.println("##### Printing webpage title #####\n" + res.parse().title() + "\n");

        Document subjectPage = Jsoup.connect("https://moj.tvz.hr").data("TVZ", tvz).cookies(cookies).get();

        String subjectTitle = subjectPage.title();
        System.out.println("##### Printing webpage title #####\n" + subjectTitle + "\n");