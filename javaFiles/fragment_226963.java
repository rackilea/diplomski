URL urlSB = new URL("https://www.groupon.com/browse/chicago?z=skip");
URLConnection urlConnection = urlSB.openConnection();
urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:5.0) Gecko/20100101 Firefox/25.0");
urlConnection.connect();
HtmlCleaner cleaner = new HtmlCleaner();
CleanerProperties props = cleaner.getProperties();
props.setNamespacesAware(false);
TagNode tagNodeRoot = cleaner.clean(urlConnection.getInputStream());
new PrettyXmlSerializer(props).writeToFile(tagNodeRoot, "cleaned.xml", "utf-8");