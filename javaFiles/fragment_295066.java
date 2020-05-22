// Create an element and programatically set its attributes
  ObjectElement o = Document.get().createObjectElement();
  o.setWidth("100%");
  o.setHeight("100%");
  o.setData("/media/invoice1.pdf");

  // Attach the element to the document
  Document.get().getBody().appendChild(o);

  // Optionally you could wrap your element into a widget.
  Widget w = HTMLPanel.wrap(o);