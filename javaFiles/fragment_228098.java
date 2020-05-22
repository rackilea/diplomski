public static void scan() {
    synchronized (Element.elements) {
        for (Element element : Element.elements) {
            if (element.containsMouse()) {
                if (element.getSize() < 24) {
                    Element.elements.remove(element);
                } else {
                    element.cloneItself();
                    Element.elements.remove(element);
                }
                skip = true;
                break;
            }
        }
    }
}