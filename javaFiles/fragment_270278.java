public class Test {

    public static void main(String[] args) throws Exception {
        // sample xml
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Result>\n" +
                "  <ResultDetails>\n" +
                "  <SearchFilmResult ItemType=\"film\">\n" +
                " <FilmDetails>\n" +
                "    <FilmDetail>\n" +
                "       <Film Code=\"INCEPTION\"><![CDATA[INCEPTION 2010]]></Film>\n" +
                "       <Imdb>8.8</Imdb>\n" +
                "       <FilmInformation>\n" +
                "            <Director><![CDATA[Christopher Nolan]]></Director> \n" +
                "            <Actors>\n" +
                "                <Actor1><![CDATA[Leonardo DiCaprio]]></Actor1>\n" +
                "                <Actor2><![CDATA[Joseph Gordon-Levitt]]></Actor2>\n" +
                "                <Actor3><![CDATA[Ellen Page]]></Actor3>\n" +
                "            </Actors>  \n" +
                "       </FilmInformation>\n" +
                "    </FilmDetail>\n" +
                "   </FilmDetails>\n" +
                "  </SearchFilmResult>\n" +
                "  </ResultDetails>\n" +
                "</Result>";

        // read the xml
        InputSource source = new InputSource(new StringReader(xml));

        // build a document model
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(source);

        // create an xpath interpreter
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        // evaluate nodes
        String filmCode = xpath.evaluate("Result/ResultDetails/SearchFilmResult/FilmDetails/FilmDetail/Film/@Code", document);
        String filmName = xpath.evaluate("Result/ResultDetails/SearchFilmResult/FilmDetails/FilmDetail/Film", document);
        String imdb = xpath.evaluate("Result/ResultDetails/SearchFilmResult/FilmDetails/FilmDetail/Imdb", document);
        String director = xpath.evaluate("Result/ResultDetails/SearchFilmResult/FilmDetails/FilmDetail/FilmInformation/Director", document);

        // get actor data
        XPathExpression expr = xpath.compile("Result/ResultDetails/SearchFilmResult/FilmDetails/FilmDetail/FilmInformation/Actors/child::*");
        NodeList actors = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

        StringBuilder sb = new StringBuilder();

        // compile actor list
        for ( int i = 0; i < actors.getLength(); i++ ) {
            String actorName = actors.item(i).getFirstChild().getNodeValue();
            if ( i > 0 ) {
                sb.append(", ");
            }
            sb.append(actorName);
        }

        // print output
        System.out.println("Film Code = " + filmCode);
        System.out.println("Film Name = " + filmName);
        System.out.println("IMDB = " + imdb);
        System.out.println("Director = " + director);
        System.out.println("Actors = " + sb.toString());
    }
}