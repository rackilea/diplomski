for (String item: results) {
    Element myElement = doc.createElement(item);
    // doc.appendChild(myElement); -> You don't need this one
    rootElement.appendChild(myElement);
    counter++;
}