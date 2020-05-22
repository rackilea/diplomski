Graphics2DRenderer gr = new Graphics2DRenderer();
gr.setDocument(doc, uri);
gr.layout(g2, dim);
Rectangle minSize = r.getMinimumSize();
//create new image with this size
gr.render(newG2);