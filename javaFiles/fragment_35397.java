String url = "http://www.omdbapi.com/?t=Private%20Ryan&y=&plot=short&r=xml";
// Parse the doc using an XML parser
Document doc = Jsoup.parse(new URL(url).openStream(), "UTF-8", "", Parser.xmlParser());
// Select the first element "movie"
Element movieFromXml = doc.select("movie").first();
// Get its attribute "genre"
String genre = movieFromXml.attr("genre");
// Print the result
System.out.println(genre);