for(int j = 0; j <= 2; j++) {
    c.fill = GridBagConstraints.BOTH;
    c.gridy = j;
    for(int i = 0; i < 4; i++) {
        c.gridx = i;
        panel.add(buttons.get(i), c); // <---- Do you see the problem?
    }
}