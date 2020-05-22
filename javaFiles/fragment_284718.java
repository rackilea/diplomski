JRadioButton rOneStar = createJRadioButton(1);
JRadioButton rTwoStars = createJRadioButton(2);
JRadioButton rThreeStar = createJRadioButton(3);
JRadioButton rFourStars = createJRadioButton(4);
JRadioButton rFiveStars = createJRadioButton(5);

// group stars
ButtonGroup starGroup = new ButtonGroup();
starGroup.add(rOneStar);
starGroup.add(rTwoStars);
starGroup.add(rThreeStars);
starGroup.add(rFourStars);
starGroup.add(rFiveStars);

rOneStar.addActionListener(createActionListener());
rTwoStars.addActionListener(createActionListener()); 
rThreeStars.addActionListener(createActionListener());
rFourStars.addActionListener(createActionListener());
rFiveStars.addActionListener(createActionListener());