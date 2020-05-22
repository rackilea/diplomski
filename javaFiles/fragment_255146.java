int index = 0; // <---- Make sure you've declared and initialized the index

for(int j = 0; j <= 2; j++) {
    c.fill = GridBagConstraints.BOTH;
    c.gridy = j;
    for(int i = 0; i < 4; i++) {
        c.gridx = i;
        panel.add(buttons.get(index), c); // <---- This will actually do what you want
        index++; // <---- Don't forget to increment the index to get to all the buttons
    }
}