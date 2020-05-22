private static JComponent buildButtons() {
    for (JButton button : Arrays.asList(launchGame, settings, exitGame)) {
        button.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
    }

    Box b = Box.createVerticalBox();
    b.add(Box.createVerticalStrut(10));
    b.add(launchGame);
    b.add(Box.createVerticalStrut(10));
    b.add(settings);
    b.add(Box.createVerticalStrut(10));
    b.add(exitGame);
    b.add(Box.createVerticalStrut(10));

    return b;
}

static JComponent buildUI() {
    Box b = Box.createHorizontalBox();
    b.add(news);
    b.add(Box.createHorizontalStrut(10));
    b.add(buildButtons());
    b.add(Box.createHorizontalStrut(10));

    return b;
}

public static void main(String[] args)
{
    news.setEditable(false);
    news.append("                        NEWS:\n");
    news.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.gray, Color.black));

    frame.add(buildUI());
    frame.pack();
    frame.setVisible(true);
}