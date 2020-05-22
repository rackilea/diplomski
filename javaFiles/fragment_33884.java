InputStream is = request.getInputStream();
    Document doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder().parse(is);
    String id = ((Element) doc.getElementsByTagName("request").item(0))
            .getAttribute("id");
    String hash = ((Element) doc.getElementsByTagName("app").item(0))
            .getAttribute("hash");