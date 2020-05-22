for (int i = 0; i < urls.getLength(); i++) {
    Node copy = result.importNode(urls.item(i), true);
    root.appendChild(result.createTextNode("\n\t"));
    root.appendChild(copy);
}
root.appendChild(result.createTextNode("\n"));