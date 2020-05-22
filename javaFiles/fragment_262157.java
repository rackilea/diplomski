public class Main {

    public interface BoardElement {
        /** The name of this BoardElement */
        public String getName();

        /** What happens when Player lands on this BoardElement */
        public void onLanding(Player player);

        ...
    }

    public class Player { ... }
    public class Property implements BoardElement { ...  }
    public class Utility implements BoardElement { ... }
    public class Corner implements BoardElement { ... }

    public static void display () {
        List<BoardElement> board = ...;
        System.out.println(board.get(0).getName());
        for(BoardElement element : board) {
            System.out.println(element.getName());
        }
    }
}