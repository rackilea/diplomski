//First add actual content
stack.add(content);

//Second add wrapped overlay object
Table overlay = new Table();
overlay.add(overlayWidget).expand().fillX().bottom().left();
stack.add(overlay);