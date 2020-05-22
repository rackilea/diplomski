//your classes must implement a interface:
public interface IGame
{
    void tutorial();
}
public class femGame: IGame
{
    public void tutorial()
    {
        //implementation...
    }
}
public class maleGame: IGame
{
    public void tutorial()
    {
        //implementation...
    }
}

//...

//using plymorphism:

IGame gamePlay;
if (player.femaleBool)
    {
        player.trueName = player.maleNames[nameNum[0]];
        gamePlay = new femGame();
    }//end if
    else
    {
        player.trueName = player.femNames[nameNum[0]];
        gamePlay = new maleGame();
    }//end else
gamePlay.tutorial();