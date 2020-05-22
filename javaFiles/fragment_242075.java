public class Test {

    static class Node {

        final int level;
        final String line;
        final List<Node> children = new ArrayList<>();

        Node(int level, String line) {
            this.level = level;
            this.line = line;
        }

        void write(PrintStream out) {
            int n = 1;
            if (line.contains("OCCURS"))
                n = Integer.parseInt(line.replaceAll("^.* |[^\\d]*$", ""));
            if (line.contains("PIC"))
                out.println(line);
            for (int i = 0; i < n; ++i)
                for (Node child : children)
                    child.write(out);
        }

    }

    static Node parse(String inputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFile)))) {
            List<Node> lines = new ArrayList<>();
            String line;
            int no = 0;
            while ((line = reader.readLine()) != null) {
                ++no;
                line = line.trim();
                int level = Integer.parseInt(line.replaceFirst("\\s.*", ""));
                Node child = new Node(level, line);
                if (lines.size() > 0) {
                    boolean found = false;
                    for (int i = lines.size() - 1; i >= 0; --i) {
                        Node parent = lines.get(i);
                        if (parent.level < level) {
                            parent.children.add(child);
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        throw new RuntimeException(
                            "parent not found for line " + no + " : " + line);
                }
                lines.add(child);
            }
            return lines.get(0);
        }
    }

    public static void main(String[] args) throws IOException {
        // Step 1
        Node top = parse("C:\\Users\\DadMadhR\\Desktop\\temp\\copybook\\test_Copybook.cpy");
        // Step 2
        top.write(System.out);
    }

}