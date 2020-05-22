public class Test {

    HashMap<String, Color> myMap = new HashMap<String, Color>();

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        myMap.put("apple", Color.RED);
        myMap.put("apples", Color.RED);
        myMap.put("green", Color.GREEN);
        String text = "This is a green apple and  I like to eat Apples";

        JTextPane textPane = new JTextPane();
        StyledDocument doc = textPane.getStyledDocument();



        Style style = textPane.addStyle("Red Style", null);
        StyleConstants.setForeground(style, Color.red);
        ArrayList<Chunk> chunks = getColorsBasedOnText(text, textPane);
        try {
            for (Chunk chunk : chunks) {
                doc.insertString(doc.getLength(), chunk.text + " ", chunk.style);
            }
        } catch (BadLocationException e) {
        }

        JFrame frame = new JFrame("Test");
        frame.getContentPane().add(textPane);
        frame.pack();
        frame.setVisible(true);
    }

    private ArrayList<Chunk> getColorsBasedOnText(String text, JTextPane textPane) {
        ArrayList<Chunk> chunks = new ArrayList<Chunk>();
        for (String word: text.split(" ")) {
            Chunk chunk = new Chunk();
            chunk.text = word;
            Color color =  myMap.get(word.toLowerCase());
            if (color != null) {
                chunk.style = textPane.addStyle("Style", null);
                StyleConstants.setForeground(chunk.style, color);
            }
            chunks.add(chunk);
        }
        return chunks;
    }

    private class Chunk {
        public String text;
        public Style style;
    }