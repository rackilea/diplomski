public static void main(String[] args) {
    String readXML;
    URL url;
    URLConnection urlconn;

    try {
        url = new URL("http://vrijeme.hr/hrvatska_n.xml");
        urlconn = url.openConnection();

        BufferedReader bfr = null;
        InputStreamReader inst = null;
        FileOutputStream fout = null;
        Writer out = null;
        try { // read & write in the same block
            inst = new InputStreamReader(urlconn.getInputStream());
            bfr = new BufferedReader(inst);
            fout = new FileOutputStream("NewFile.xml");
            out = new OutputStreamWriter(fout, "UTF8");
            while ((readXML = bfr.readLine()) != null) {
                out.write(readXML);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally { // cleanup your resources
            if (out != null) {
                out.close();
            }
            if (fout != null) {
                fout.close();
            }
            if (bfr != null) {
                bfr.close();
            }
            if (inst != null) {
                inst.close();
            }
        }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("NewFile.xml");                                            //Dokument

        NodeList cityList = doc.getElementsByTagName("GradIme");
        Node cNode = cityList.item(12);

        if (cNode.getNodeType() == Node.ELEMENT_NODE) {

            Element cElement = (Element) cNode;
            String city = cElement.getTextContent();
            System.out.println("Ime grada: " + city);
        }

        NodeList tempList = doc.getElementsByTagName("Temp");                                //Element po nazivu
        Node nNode = tempList.item(12);                                                        //Item number

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {                                        // provjeta tipa podataka == Element

            Element eElement = (Element) nNode;                                            // Element nNode
            String temperatura = eElement.getTextContent();                                    //uzima text iz elementa
            System.out.println("Temperatura:" + temperatura + " C");

            NodeList vlagaList = doc.getElementsByTagName("Vlaga");
            Node vNode = vlagaList.item(12);

            if (vNode.getNodeType() == Node.ELEMENT_NODE) {

                Element vElement = (Element) vNode;
                String vlaga = vElement.getTextContent();
                System.out.println("Vlaga u zraku: " + vlaga + "%");
            }
        }
    } catch (ParserConfigurationException | IOException | SAXException e) {
        e.printStackTrace();
    }
}