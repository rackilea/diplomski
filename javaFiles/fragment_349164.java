BufferedImage myImage = ImageIO.load(...);
JPanel leftPanel = new ImagePanel(myImage);

//Add panel to splitpanel
JSplitPane mySplitPane= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT)
mySplitPane.setLeftComponent(leftPanel);