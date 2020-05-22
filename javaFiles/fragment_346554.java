...
HashMap<String, Element> foundProductLineNames = new HashMap<String, Element>();
...

while (rp.next()) {
    String productLineName = rp.getString("productLine");
    /* If wee see this product line name for the first time... */
    if (!foundProductLineNames.containsKey(productLineName)) {
        /* ...we have to create a DOM element for it and append it to the product set. */
        Element proLineNameElem=xmlDoc.createElement("product_line_name");
        proLineNameElem.appendChild(xmlDoc
            .createTextNode(rp.getString("productLine")));
        product_set.appendChild(proLineNameElem);

        /* Store the product line for later use. */
        foundProductLineNames.put(productLineName, proLineNameElem);
    }
    /* Proceed with your original code for adding products but use
       foundProductLineNames.get(productLineName) instaed of pro_line_name.
       For example: */

    Element productElem=xmlDoc.createElement("product");
    foundProductLineNames.get(productLineName).appendChild(productElem);
}