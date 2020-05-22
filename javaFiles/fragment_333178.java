public class ParseData implements ParserData {
Item item;

InputStream inputstrm = null;

public ParseRSS(InputStream is) {
    inputstrm = is;
}

@Override
public List<Item> parse() {
    // TODO Auto-generated method stub
    RootElement root = new RootElement("channel");
    final List<Item> responsearray = new ArrayList<Item>();
    Element dataset = root.getChild("item");

    dataset.setStartElementListener(new StartElementListener() {

        @Override
        public void start(Attributes attributes) {
            // TODO Auto-generated method stub
            parameter = new Item();
        }
    });
    dataset.setEndElementListener(new EndElementListener() {

        @Override
        public void end() {
            // TODO Auto-generated method stub
            responsearray.add(parameter);
        }
    });

    dataset.getChild("title").setEndTextElementListener(
            new EndTextElementListener() {

                @Override
                public void end(String body) {
                    // TODO Auto-generated method stub
                    parameter.setTitle(body);
                }
            });

    dataset.getChild("link").setEndTextElementListener(
            new EndTextElementListener() {

                @Override
                public void end(String body) {
                    // TODO Auto-generated method stub
                                           if(body != null)
                    parameter.setLink(body);
                }
            });


    try {
        Xml.parse(inputstrm, Xml.Encoding.UTF_8, root.getContentHandler());
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SAXException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return responsearray;
}