public static String toString(Element element) {
    Format format = Format.getPrettyFormat();
    format.setTextMode(Format.TextMode.NORMALIZE);
    format.setEncoding("UTF-8");

    XMLOutputter xmlOut = new XMLOutputter(noNamespaces); 
    xmlOut.setFormat(format);
    return xmlOut.outputString(element);
}