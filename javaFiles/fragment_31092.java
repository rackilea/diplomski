// Can't just remove the object from the parent,
    // since in the parent, it may be wrapped in a JAXBElement
    for (Object ox : theList) {
    if (XmlUtils.unwrap(ox).equals(bm)) {
        return theList.remove(ox);
    }