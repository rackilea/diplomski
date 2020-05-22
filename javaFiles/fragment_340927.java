String url = "http://zemberek-web.appspot.com/zemberek.jsp?ts=1367326940830&giris=%s&islem=YAZI_COZUMLE";

String query = "MyParamĄĘÓŚŁ";

String formattedUrl = String.format(url, URLEncoder.encode(query, "UTF-8"));

Document document = Jsoup.connect(formattedUrl).get();

String result = document.select("taconite-root > taconite-replace-children > div").text();

System.out.println(result);