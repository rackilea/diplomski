HtmlAnchor link = null;
    for (HtmlAnchor anchor : anchors) {
        String str = anchor.asText();
        if (anchor.asText().equals("Start"))
           link = anchor;
    }
    HtmlPage page2 = link.click();