String url = "http://sjp.pl/maść";       
System.out.println("BEFORE " + url);

String encodedURL = URI.create(url).toASCIIString();
System.out.println("AFTER " + encodedURL);

System.out.println("Title: " + Jsoup.connect(encodedURL).get().title());