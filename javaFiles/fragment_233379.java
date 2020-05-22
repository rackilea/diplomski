AffineTransform previous = gr.getTransform();
AffineTransform newTransform = new AffineTransform(previous);
newTransform.scale(0,-1);
gr.setTransform(newTransform);

gr.setTransform(previous);