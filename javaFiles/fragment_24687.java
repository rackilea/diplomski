public class Freq {
    private static final int ROWS = 26;
    private static final int COLS = 26;
    private static int[][] alphabet = new int[ROWS][COLS];
    private static boolean[][] visited = new boolean[ROWS][COLS];

    public static void main(String[] args) {
        String line;
        Scanner userInput = new Scanner(System.in);
        while (userInput.hasNextLine()) {
            clearVisited();
            line = userInput.nextLine();
            processLine(line);
        }
        printArray();
    }

    public static void clearVisited() {
        for (int r=0; r < visited.length; r++) {
            for (int c=0; c < visited[r].length; c++){
                visited[r][c] = false;
            }
        }
    }

    public static void processLine(String line) {
        line = line.toUpperCase();
        for (int i=0; i < line.length()-1; i++) {
            char firstLetter = line.charAt(i);
            char secondLetter = line.charAt(i + 1);
            if (!visited[firstLetter-65][secondLetter-65]) {
                alphabet[firstLetter - 65][secondLetter - 65] += 1;
                visited[firstLetter-65][secondLetter-65] = true;
            }
        }
    }
}