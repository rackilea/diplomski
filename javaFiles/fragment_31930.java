if(y >= Game.HEIGHT - 50)
{
    //game.decreaseHealth();
    //game.setT("");              // <-- Commented this line out
    c.removeEnemy(this);
    game.setEnemy_notkilled(game.getEnemy_notkilled() + 1);
    if(game.getT().equals(text))  // <-- Added this if before calling falseTarget()
    {                             //     and clearing the game's current enemy text
        game.falseTarget();
        game.t ="";
    }

}