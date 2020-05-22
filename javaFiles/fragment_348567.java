// this creates the JPanels and sets their preferred sizes
JFrame frame = new MainFrame("Warlock of Firetop Mountain");

//this sets your size static contents -- after the above's been done!
Toolkit tk = Toolkit.getDefaultToolkit();
Frame.xsize = (int) tk.getScreenSize().getWidth();
Frame.ysize = (int) tk.getScreenSize().getHeight();