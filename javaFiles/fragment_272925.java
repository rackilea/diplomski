String url = "http://www.google.com/search?q="+URLEncoder.encode(keywords); 
        Document response = Jsoup.connect(url)
                            .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                            .referrer("http://www.google.com").get();
        Elements records = response.select("body #ires li.g");
        for (int i = 0; i < records.size()-1; i++) {
            System.out.println(records.get(i));
        }