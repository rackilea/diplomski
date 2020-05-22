public void actionPerformed(ActionEvent e)
{
    if(e.getSource()==start)
    {
        //what to do here?
        CardLayout cardLayout = (CardLayout) Virus.thegame.getLayout();
        cardLayout.next(Virus.thegame);
    }
}