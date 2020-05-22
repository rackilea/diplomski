public AjouterBouton(int nombre, JPanel pan)
{
    JButton[] buttons = new JButton[nombre];

    for(int i = 0; i < buttons.length; i++)
    {
        buttons[i] = new JButton();
        buttons[i].setBackground(Color.LIGHT_GRAY);
        //JPanel pan = Main.grille;
        pan.add(buttons[i]);
    }
}