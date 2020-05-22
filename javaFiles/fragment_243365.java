ArrayList<String> result = new ArrayList<String>();

    List<Element> elementList = xmlDocument.selectNodes("//str[@name='author']");

    if (elementList == null) {
        return result;
    }

    ArrayList<Element> listAuthor = new ArrayList<Element>();

    for (int i = 0; i < elementList.size(); i++) {
        Element el = elementList.get(i);
        if (el.getText().equalsIgnoreCase(author)) {
            listAuthor.add(el);
        }
    }

    if (listAuthor.size() == 0) {
        return result;
    }
    else {
        String authorLine = "";

        for (int i = 0; i < listAuthor.size(); i++) {

            Element element = listAuthor.get(i);

            Element price = (Element)element.getParent().selectSingleNode("./int[@name='price']");
            Element subauthor = (Element) element.getParent().selectSingleNode("./str[@name='subauthor']");

            authorLine = "author-" + author + ",price-" + price.getText() + ",subauthor-" + subauthor.getText();

            result.add(authorLine);
        }
    }

    return result;
}