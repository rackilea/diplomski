public class Maze {

    private char[][] mazeData;

    public static void main(String[] args) {
        Maze test = new Maze();
    }

    public Maze() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("c:/testing.txt"), Charset.defaultCharset());

            mazeData = new char[lines.size()][];
            for (int i = 0; i < lines.size(); i++) {
                mazeData[i] = lines.get(i).toCharArray();
            }
            int columns = mazeData[0].length;
            int rows = lines.size();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(mazeData[i][j]);
                }
                System.out.println();
            }
        } catch (IOException ex) {
            System.out.println("failed: " + ex.getMessage());
        }
    }
}