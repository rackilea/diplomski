Element AuthHeader = new Element();
AuthHeader.setName("Auth");
AuthHeader.setNamespace(namespace);

Element element = new Element();
element.setName("Username");
element.setNamespace(namespace);
element.addChild(Element.TEXT, username);
AuthHeader.addChild(Element.ELEMENT, element);

element = new Element();
element.setName("Password");
element.setNamespace(namespace);
element.addChild(Element.TEXT, password);
AuthHeader.addChild(Element.ELEMENT, element);

headers[0] = AuthHeader;

envelope.headerOut = headers;