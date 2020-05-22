ImageIcon yourImage = new ImageIcon("pathToYourImage");
//Clean the button
yourButton.setContentAreaFilled(false);
yourButton.setFocusPainted(false);
yourButton.setBorderPainted(false);
//Set the image
yourButton.setIcon(yourImage); //or new JButton(yourImage);