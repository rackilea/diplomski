for (Element e : content) {
    if (e.nodeName().equals("p")) {
        for (Element child : e.children()) {
            if (child.nodeName().equals("img")) child.remove();
        }
    }
}