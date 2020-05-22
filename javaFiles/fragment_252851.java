public class W {
    int x;
    int y;
    public W(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

ArrayList<W> m = new ArrayList<W>(); // can be 'new ArrayList<>()` in Java 7
m.add(new W(1, 2));
m.add(new W(5,-3));
// etc.

for (int i=0; i<m.size(); i++) {
    W w = m.get(i);
    System.out.println("m[" + i + "]=(" + w.x + "," + w.y + ")");
}

for (W w : m) {
    System.out.println("next W: (" + w.x + "," + w.y + ")");
}