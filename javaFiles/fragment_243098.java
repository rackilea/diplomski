Element root = new Element("organization", "http://schemas.test");
        Document document = new Document(root); 
        Element element = new Element("Email","http://schemas.test");
        element.appendChild("test@test.com");
        root.appendChild(element);
System.out.print(document.toXML());