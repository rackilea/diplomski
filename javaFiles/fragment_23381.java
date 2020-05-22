URL fontUrl;
        try {
            fontUrl = new URL("http://www.webpagepublicity.com/" +
                    "free-fonts/a/Airacobra%20Condensed.ttf"); // dummy font 

            Font myFont = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
            myFont = myFont.deriveFont(Font.PLAIN,20);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(myFont);


            button.setText("<html><font face='Airacobra Condensed'>Hello </font>World</html>");

        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (FontFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }