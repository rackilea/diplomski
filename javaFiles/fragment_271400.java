XPathFactory xpf = XPathFactory.newInstance();
    XPath xp = xpf.newXPath();

    NodeList nl = (NodeList) xp.evaluate("//item/title/text()", doc,
            XPathConstants.NODESET);
    for (int i = 0; i < nl.getLength(); ++i) {
        System.out.println(nl.item(i).getNodeValue());
    }