public void paintComponent (Graphics page)
{
    super.paintComponent(page);

    Color brown = new Color(160, 82, 45);
    page.setColor (brown);
    page.fillRect (0, 630, 1000, 70);

    for (SkeletonHand hand : hands) {
        hand.draw(page)l
    }

    cross1.draw(page);
    cross2.draw(page);
    headStone1.draw(page);
    headStone2.draw(page);

}