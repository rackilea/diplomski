String filename="path/to/file/whatever.ttf";//this is for testing normally we would store the font file in our app (knows as an embedded resource), see this for help on that http://stackoverflow.com/questions/13796331/jar-embedded-resources-nullpointerexception/13797070#13797070

Font font = Font.createFont(Font.TRUETYPE_FONT, new File(filename));
font = font.deriveFont(Font.BOLD,28);

GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
ge.registerFont(font);

JLabel l = new JLabel("Some Text");
l.setFont(font);