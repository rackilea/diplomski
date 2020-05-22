Document doc = new Document();
Namespace sNS = Namespace.getNamespace("someNS", "someNamespace");
Element element = new Element("SomeElement", sNS);
element.setAttribute("someKey", "someValue", Namespace.getNamespace("someONS", "someOtherNamespace"));
Element element2 = new Element("SomeElement", Namespace.getNamespace("someNS", "someNamespace"));
element2.setAttribute("someKey", "someValue", sNS);
element.addContent(element2);
doc.addContent(element);