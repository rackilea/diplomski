NodeList nl = doc.getDocumentElement().getChildNodes();
    for (int i = 0; i < nl.getLength(); i++) {
        if (nl.item(i).getNodeType() == Element.COMMENT_NODE) {
            Comment comment=(Comment) nl.item(i);
            System.out.println(comment.getData());
        }
    }