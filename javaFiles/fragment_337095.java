public class BeerParser extends DefaultHandler {
    private List<Beer> list = new ArrayList<>();
    private Beer beer;
    private String element;

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        BeerParser bp = new BeerParser();
        parser.parse(new File("1.xml"), bp);
        System.out.println(bp.list);
    }

    @Override
    public void startElement(String s, String s1, String element, Attributes attributes) {
        if (element.equals("beer")) {
            beer = new Beer();
        }
        this.element = element;
    }

    @Override
    public void endElement(String s, String s1, String element) {
        if (element.equals("beer")) {
            list.add(beer);
            beer = null;
        }
    }

    @Override
    public void characters(char[] ac, int i, int j) {
        if (beer != null) {
            String value = new String(ac, i, j);
            if (element.equals("type")) {
                beer.setType(value);
            } else if (element.equals("brewery")) {
                beer.setBrewery(value);
            } else if (element.equals("bottling")) {
                beer.setBottling(value);
            } else if (element.equals("price")) {
                beer.setPrice(value);
            } else if (element.equals("place")) {
                beer.setPlace(value);
            }
        }
    }
}