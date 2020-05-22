import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        char[] board = new char[]
        {
            'o', 'o', 'o',
            'x', 'x', 'x',
            'x', 'x', 'x'
        };

        List<int> moves = new ArrayList<int>();
        generateMoves ( board, moves );
    }

    public static void generateMoves(char[] board, List<int> moves )
    {
        for (int i = 0; i < board.length; ++i)
        {
            if (board[i] == 0)
            {
                moves.add ( i );
            }
        }
    }
}