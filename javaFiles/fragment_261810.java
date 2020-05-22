for (String tag : tags) {

    tagPane.add(new JToggleButton(tag), gbc);
    gbc.gridx--;
    if (gbc.gridx < 0) {
        gbc.gridx = 3;
        gbc.gridy++;
    }

}
JLabel filler = new JLabel();
gbc.gridx = 4;
gbc.gridy = 0;
gbc.weightx = 1;
tagPane.add(filler, gbc);