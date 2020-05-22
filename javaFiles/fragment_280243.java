Table header = new Table();
Table header_container = new Table(skin);

// assign a background behind the header contents
Drawable tableBackground = skin.getDrawable("top_bg");

//some position tweaks to resize the background to the wanted height
tableBackground.setMinHeight(10);
tableBackground.setBottomHeight(30);
tableBackground.setTopHeight(10);
header_container.setBackground(tableBackground);

// headerBar is another table that contains the buttons that are in the header 
header.add(headerBar).expandX().fillX();
header_container.add(header).expandX().fillX();
head.addActor(header_container);