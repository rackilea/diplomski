private static void showLeafPaths(Element elem, StringBuilder path) {
    final int pathLen = path.length();
    if (pathLen != 0)
        path.append(", ");
    path.append(elem.getAttribute("id"));
    boolean hasChild = false;
    for (Node child = elem.getFirstChild(); child != null; child = child.getNextSibling())
        if (child.getNodeType() == Node.ELEMENT_NODE) {
            hasChild = true;
            showLeafPaths((Element)child, path);
        }
    if (! hasChild)
        System.out.println(path);
    path.setLength(pathLen);
}