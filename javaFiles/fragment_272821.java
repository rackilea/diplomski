public class GameModel
{

    ....

    public boolean isValidPosition(int x, int y)
    {
        return (x >= 0) && (x < size) && (y >= 0) && (y < size);
    }
}