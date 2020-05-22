//Pull all links from the body for easy retrieval
public ArrayList<String> pullLinks(String text) 
{
    ArrayList<String> links = new ArrayList<String>();

    //String regex = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&@#/%=~_()|]";
    String regex = "\\(?\\b(https?://|www[.]|ftp://)[-A-Za-z0-9+&@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&@#/%=~_()|]";

    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(text);

    while(m.find()) 
    {
        String urlStr = m.group();

        if (urlStr.startsWith("(") && urlStr.endsWith(")"))
        {
            urlStr = urlStr.substring(1, urlStr.length() - 1);
        }

            links.add(urlStr);
    }

        return links;
}