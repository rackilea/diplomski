public class Sorter {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("team"));
            List<SortableLine> lines = new ArrayList<SortableLine>();
            while(scanner.hasNext()) {
                lines.add(new SortableLine(scanner.nextLine()));
            }
            Collections.sort(lines);
            for(SortableLine line : lines) {
                System.out.println(line.line);
            }
        } catch(FileNotFoundException e) {
            System.err.println("File not found");
        }
    }

    private static class SortableLine implements Comparable<SortableLine> {
        private String sortCol;
        private String line;

        private SortableLine(String line) {
            this.line = line;
            this.sortCol = line.substring(24, 26);
        }

        public int compareTo(SortableLine other) {
            return sortCol.compareTo(other.sortCol);
        }
    }
}