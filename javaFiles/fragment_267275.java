/*
 * showPanel()
 * Method to switch to a different panel
 * @author Rick Slinkman
 */
public void showPanel(String newPanel) 
{
        game.setCurrentPanel(newPanel);
    this.cardLayout = (CardLayout) cards.getLayout();
    cardLayout.show(cards, "" + newPanel);
    cards.revalidate();
}