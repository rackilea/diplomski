if(/*stand before a troll condition*/)
{
    attackButton.setVisible(true);
    openButton.setVisible(false);
}
else if(/*stand before a door condition*/)
{
    attackButton.setVisible(false);
    openButton.setVisible(true);
}
else  // standing before nothing
{
    attackButton.setVisible(false);
    openButton.setVisible(false);
}