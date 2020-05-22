String page = "http://www.somepage.com";

//get input stream from the URL
InputStream in = new URL(page).openStream();

//parse document using input stream and specify the charset
Document doc = Jsoup.parse(in, "ISO-8859-1", page);

//..do your processing