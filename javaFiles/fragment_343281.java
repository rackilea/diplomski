// Using just your anchor html tag
String html = "<a href=\"/showship.php?mmsi=235083844\">Sunsail 4013</a>";
Document doc = Jsoup.parse(html);

// Just selecting the anchor tag, for your implementation use a generic one
Element link = doc.select("a").first();

// Get the attribute value
String url = link.attr("href");

// Check for nulls here and take the substring from '=' onwards
String id = url.substring(url.indexOf('=') + 1);
System.out.println(id + " "+ link.text());