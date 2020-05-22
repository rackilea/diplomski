Element body = doc.select("body").first();
    Element newBody = new Element("body");

    for (Node n : body.childNodes()) {
        if (n instanceof Element && "div".equals(((Element) n).tagName())) {
            newBody.append(n.outerHtml());
        } else {
            Element div = new Element("div");
            div.html(n.outerHtml());
            newBody.append(div.outerHtml());
        }
    }
    body.replaceWith(newBody);