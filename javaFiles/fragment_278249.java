ImageIcon normalButtonImage = new ImageIcon("src/Images/normalIcon.png");
    normalSetupButton = new JButton();
    normalSetupButton.setIcon(normalButtonImage);
    normalSetupButton.setName("Normal Setup");
    normalSetupButton.addActionListener(buttonHandler);
    normalSetupButton.setToolTipText("Set up simulation for normal execution");