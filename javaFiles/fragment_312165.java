public static void main(String[] args)
{
    news.setEditable(false);
    news.append("                        NEWS:\n");
    news.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.gray, Color.black));

    frame.setLayout(new GridBagLayout());
    c.fill = GridBagConstraints.VERTICAL;
    c.weighty = 0.5;
    c.gridx = 0;
    c.gridy = 0;
    c.gridheight = 3;
    frame.add(news, c);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(10, 10, 10, 10); // 10 is the marginal
    c.weightx = 0.5;
    c.gridx = 1;
    c.gridheight = 1;
    frame.add(launchGame, c);
    c.gridy = 1;
    frame.add(settings, c);
    c.gridy = 2;
    frame.add(exitGame, c);

    frame.pack();
    frame.setVisible(true);
}