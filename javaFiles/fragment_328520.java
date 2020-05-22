public static Element findElement(Element current, String nameOfElement) {
        Element searchedElement = null; // this element I want to return
        List children = current.getChildren(); // current is a root element passed to method
        Iterator iterator = children.iterator();
        //label:
        while (iterator.hasNext()) {
            Element child = (Element)iterator.next();   
            if (child.getName().equals(nameOfElement)) {
                searchedElement = child; // on some level it founds it
                System.out.println("!!!"); // it's just a marker to see that action happens
                //break label;
                break;
            }
            searchElement = findElement(child, nameOfElement);
            if(searchElement != null)
                return searchElement;

        }
        return searchedElement;     
    }