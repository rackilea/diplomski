String nome;
    Element root;
    Element papel;
    Node node;
    URL url = new URL(
            "http://www.bmfbovespa.com.br/Pregao-Online/ExecutaAcaoAjax.asp?CodigoPapel=SUZB5");
    SAXReader reader = new SAXReader();
    Document document = reader.read(url);
    root = document.getRootElement();
    System.out.println("" + root.asXML());
    papel = root.element("Papel");
    System.out.println("Nome:" + papel.attributeValue("Nome"));
    nome = papel.attributeValue("Nome");