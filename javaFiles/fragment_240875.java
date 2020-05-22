String query = "abc";
String url = "https://www.sosnc.gov/trademrk/results.aspx?searchstr=" +
              query +
             "&Type=GOODS";
Connection.Response response = Jsoup.connect(url).timeout(45000)
            .method(Connection.Method.GET)
            .ignoreContentType(true)
            .userAgent("Mozilla/5.0 (Windows NT 6.3; rv:40.0) Gecko/20100101 Firefox/40.0")

            .followRedirects(true)
            .execute();
System.out.println(response.body());