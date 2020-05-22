JPanel ImageDisplay = new JPanel(new GridBagLayout());
    GridBagConstraints g = new GridBagConstraints();
    g.insets = new Insets(5, 5, 5, 5); // insets for all components
    g.weightx = 0.0;
    g.weighty = 0.0;

    JRadioButton rawImage = new JRadioButton("Raw", true);
    JRadioButton peakPickedImage = new JRadioButton("Peak picked");
    ButtonGroup radioButtonGroup = new ButtonGroup();
    radioButtonGroup.add(rawImage);
    radioButtonGroup.add(peakPickedImage);

    g.fill = GridBagConstraints.HORIZONTAL;
    g.gridx = 0;
    g.gridy = 0;
    g.gridwidth = 1;
    g.gridheight = 1;

    ImageDisplay.add(rawImage, g);

    g.gridx = 1;
    g.gridy = 0;

    ImageDisplay.add(peakPickedImage, g);

    JPanel imagePanel = new JPanel();
    g.gridx = 0;
    g.gridy = 1;
    g.gridwidth = 2;
    g.weightx = 1.0; // fill the rest of the space
    g.weighty = 1.0;
    g.fill = GridBagConstraints.BOTH;

    imagePanel.setBorder(BorderFactory.createEtchedBorder());

    ImageDisplay.add(imagePanel, g);