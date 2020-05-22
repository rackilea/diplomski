Button b = new Button("Calcular");
b.setPixelSize(200, 127);
DOM.setStyleAttribute(b.getElement(), "background", "transparent url('http://www.greenthumbgraphics.com/images/buttons/shapes/oval.png')");
DOM.setStyleAttribute(b.getElement(), "border", "solid 0px white");
DOM.setStyleAttribute(b.getElement(), "textAlign", "center");
RootPanel.get().add(b);