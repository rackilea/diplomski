public class GameCombo extends JPanel {
  ArrayList<Game> gamesList = new ArrayList<Game>();
  Stack<Game> gamesStack = new Stack<Game>();
  private JComboBox _gameBox;

    public GameCombo() {
         setLayout(new GridLayout(1,1,1,1));
         gamesStack.push(new Game("[Halo: Reach]", 3, 1, 108.00, 2));
         _gameBox = new JComboBox(gamesStack);
         add(_gameBox);
    }
}