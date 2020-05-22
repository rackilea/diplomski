JEditorPane pane = new JEditorPane();
pane.setBorder(null);
pane.setSize(w, h);
pane.setContentType("text/html");
pane.setEditable(false);
pane.setText(html);
pane.paint(g2);