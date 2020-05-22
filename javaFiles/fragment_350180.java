// parse XML source
Document document = DocumentHelper.parseText(yourXmlText);

Iterator<Element> featureIterator =
    // get an iterator for all <feature> elements
    document.getRootElement().elementIterator("feature");

while(featureIterator.hasNext()){
    Element featureElement = featureIterator.next();
    // if <feature> has a child <name> with Content "Deviation"
    if("Deviation").equals(featureElement.elementTextTrim("name")){
        // remove this <feature> element
        featureIterator.remove();
    }
}

// write modified XML back to file
new XMLWriter(
    new FileOutputStream(yourXmlFile), OutputFormat.createPrettyPrint()
).write(document);