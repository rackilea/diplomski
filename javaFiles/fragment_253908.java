//This gives you the first Window Object that contains the panel component
Window window = SwingUtilities.getWindowAncestor(panel);

//Cast it to JFrame
JFrame frame = (JFrame) window;

 //Now, change the title
frame.setTitle("New Title");