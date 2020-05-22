Response response = Jsoup.connect("http://www.airfrance.fr/vols/paris+tunis")
                .userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.82 Safari/537.36")
                .method(Method.GET)
                .timeout(2000)
                .execute();

Document doc = Jsoup
                .connect("http://www.airfrance.fr/FR/fr/local/vols/getInstantFlexNewCalendar.do?idMonth=10&itineraryNumber=1")
                .cookies(response.cookies())
                .userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.82 Safari/537.36")
                .referrer("http://www.airfrance.fr/vols/paris+tunis")
                .timeout(2000)
                .get();

String jsonResponse = doc.text();

System.out.println(jsonResponse);