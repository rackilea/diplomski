public class Board extends JComponent {
    // I. Static variables
    public static String[] gameElements = new String[100];

    // II. Instance variables (These should be private or protected)
    private String[][] map = new String[10][10];
    private int positionX = 50;
    private int positionY = 50;
    private int i = 0; // <------------------------- Hey, you don't belong here!
    private String currentLevel = "1";

    // III. Getter/Setters
    public String[] getMap() {
        return map;
    }
    public void setMap(String[] map) {
        this.map = map;
    }

    // IV. Constructor
    public Board() { }

    // V. Overrides
    @Override
    public void paintComponent(Graphics g) { }

    // VI. Custom Instance Methods
    public void readTextFile(String fileName) { }

    public void loadLevel() { }

    // VII. Main Method
    public static void main(String[] args) { }
}