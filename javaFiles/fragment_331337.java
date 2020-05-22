for (Element elem : names) {
    if (!elem.text().contains("Zeit")) {
        Matcher m = p.matcher(elem.attributes().toString());
        elementInformation += "\n";
        elementInformation += elem.text() + " -> ";
        while (m.find()) {
            elementInformation += m.group();

        }
    }
}