/*
 * Connect to the url and parse the document; a XML Parser is used
 * instead of the default one (html)
 */
final String url = "http://www.consultacpf.com/webservices/producao/cdc.asmx?wsdl";
Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();


// Elements of any tag, but with 'types' are stored here
Elements withTypes = new Elements();

// Select all elements
for( Element element : doc.select("*") )
{
    // Split the tag by ':'
    final String s[] = element.tagName().split(":");

    /*
     * If there's a namespace (otherwise s.length == 1) use the 2nd
     * part and check if the element has 'types'
     */
    if( s.length > 1 && s[1].equals("types") == true )   
    {
        // Add this element to the found elements list
        withTypes.add(element);
    }
}