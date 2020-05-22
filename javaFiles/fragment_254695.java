public interface Path {
    public int pos(int i);

    public static class Up implements Path {
         @Override public int pos(int i) { return i; }
    }

    public static class Down implements Path {
         private int n;
         public Down(int n) { this.n = n; }
         @Override public int pos(int i) { return n - i - 1; }
    }

    public static class Fixed implements Path {
         private int v;
         public Down(int v) { this.v = v; }
         @Override public int pos(int i) { return v; }
    }