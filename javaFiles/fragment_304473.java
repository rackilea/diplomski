ArrayList<Flag> flagList = new ArrayList<Flag>();
    DocumentBuilder db = null;
    try {

        db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        AssetManager assetManager = getAssets();
        InputStream is = assetManager.open("flag_array.xml");
        org.w3c.dom.Document doc = db.parse(is);
        NodeList nodes = doc.getElementsByTagName("item");
        for(int i = 0; i< nodes.getLength();i++) {
            NamedNodeMap attr = nodes.item(i).getAttributes();

            String name = attr.getNamedItem("name").getNodeValue();
            String CountryCode = attr.getNamedItem("pic").getNodeValue().toLowerCase();

            int pic = getResources().getIdentifier(CountryCode, "drawable", getPackageName());
            Flag flag = new Flag(
                    attr.getNamedItem("name").getNodeValue(),
                    getResources().getIdentifier(CountryCode, "drawable", getPackageName()));
            flagList.add(flag);
        }

    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } catch (SAXException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }