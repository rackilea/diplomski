doc = Jsoup.connect("http://webpage.com").get();
Elements links = doc.select("a[href]");

String s = links.select("a:matches(ACRO)").first().text();
String[] str_arr = s.split(" - ");

//for example
System.out.println("before the - " + str_arr[0]);

System.out.println("after the - " + str_arr[1]);