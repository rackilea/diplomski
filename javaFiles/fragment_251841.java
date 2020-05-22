String htmlStr="<div class=\"photo-box biz-photo-box pb-60s\">"
                      + "<a href=\"/biz/the-kerry-piper-willowbrook\">"
                      + "<img class=\"photo-img\" alt=\"\" height=\"60\" src=\"http://s3-media3.ak.yelpcdn.com/bphoto/rCz-uF_qwqyb5Nnq74JeVQ/60s.jpg\" width=\"60\">"
                      + "</a>";

org.jsoup.nodes.Document doc=org.jsoup.Jsoup.parse(htmlStr);
String src=doc.select("img").attr("src");
System.out.println(src);