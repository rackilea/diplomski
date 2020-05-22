private int lastN = ??; /* Value for max guesses. */

public void repaintWord(Graphics g)
{
    if (lastN != getN())
    {
        lastN = getN();
        g.SetColor(Color.RED);
        g.drawString("You have " + lastN + " guesses left", 400, 50);
        repaint();
    }
}