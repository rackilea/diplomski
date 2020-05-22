List<String> tags = new ArrayList<>(25);
tags.add("example");
tags.add("objective");
tags.add("motivation");
tags.add("summary");
tags.add("c");
tags.add("*");
tags.add("*");
tags.add("*");
tags.add("cs");

JPanel tagPane = new JPanel(new GridBagLayout());
tagPane.setBorder(new TitledBorder("Tags"));

GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 3;
gbc.gridy = 0;
gbc.anchor = GridBagConstraints.WEST;
for (String tag : tags) {

    tagPane.add(new JToggleButton(tag), gbc);
    gbc.gridx--;
    if (gbc.gridx < 0) {
        gbc.gridx = 3;
        gbc.gridy++;
    }

}