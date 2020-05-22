public void actionPerformed(ActionEvent e)
{
    if (gameState == 0)
    {
        if(e.getSource() == click) 
        {
            JOptionPane.showMessageDialog(null, "You go forward and hit a wall.");
        }
        if(e.getSource() == click1)
        {
            JOptionPane.showMessageDialog(null, "You are now facing the opposite direction.");
            prompt.setText("What would you like to do now?");
            click.setText("Go forward!");
            click1.setText("Turn on light.");
            gameState = 1; // Update the current state of the game to represent the new "room"
        }
    }
    else if (gameState == 1)
    {
        if(e.getSource() == click) {

            JOptionPane.showMessageDialog(null, "You walk down the tunnel until you hit an intersection.");
            prompt.setText("Which way would you like to go?");
            click.setText("Left!");
            click1.setText("Right!");
            add(click2);
            click2.setText("Keep going!");
            gameState = 2;
        }
        if(e.getSource() == click1)
        {

        }
    }
    else if (gameState == 3)
    {
        // etc.
    }
}