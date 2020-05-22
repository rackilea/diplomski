public void xmlReader() {

        try {

            URL url = new URL("http://feeds.bbci.co.uk/sport/0/football/rss.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory
                    .newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(url
                    .openStream()));

            nodlist = document.getElementsByTagName("Youritem");

            for (int i = 0; i < nodlist.getLength(); i++) {
                Element element = (Element) nodlist.item(i);

                NodeList nodlistid = element.getElementsByTagName("Id");
                Element id = (Element) nodlistid.item(0);


                NodeList nodlistBaslik = element.getElementsByTagName("tagname1");
                Element baslik = (Element) nodlistBaslik.item(0);

                NodeList nodlistDetay = element.getElementsByTagName("tagname2");
                Element detay = (Element) nodlistDetay.item(0);

                NodeList nodlistKaynak = element.getElementsByTagName("tagname3");
                Element lat = (Element) nodlistKaynak.item(0);

                NodeList nodelistMedia = element.getElementsByTagName("tagname4");
                Element longi = (Element) nodelistMedia.item(0);

                NodeList nodelistTur = element.getElementsByTagName("tagname5");
                Element tur = (Element) nodelistTur.item(0);
                // String resimURL =
                // resim.getAttributes().getNamedItem("url").getNodeValue();

                NodeList nodelistMedia1 = element.getElementsByTagName("enclosure");    
                Element picture= (Element) nodelistMedia1.item(0);
                String pictureURL = resim.getAttributes().getNamedItem("picturetagname").getNodeValue();    

                xmltagname1.add(tagname1.getChildNodes().item(0).getNodeValue());
                xmltagname2.add(tagname2.getChildNodes().item(0).getNodeValue());
                xmltagname3.add(tagname3.getChildNodes().item(0).getNodeValue());
                xmltagname4.add(tagname4.getChildNodes().item(0).getNodeValue());
                xmltagname5.add(tagname5.getChildNodes().item(0).getNodeValue());


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }