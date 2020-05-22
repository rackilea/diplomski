for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
        Element element = (Element) i.next();
        tempList.addElement(element.attributeValue("id")); 

        for ( Iterator j = element.elementIterator(); j.hasNext(); ) {
            Element innerElement = (Element) j.next();
            tempAL.add(innerElement.getData().toString()); 
        }
    }