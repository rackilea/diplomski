static class Pair
{
    int x,y;

    public Pair(int x, int y) { this.x = x; this.y = y; }
}

public static void main(String[] args)
{
    java.util.ArrayList<Pair> pairs = new java.util.ArrayList<Pair>();
    Pair p = new Pair(0,0);
    pairs.add(p);
    p.x = 20; p.y = 40;
    System.out.println(pairs.get(0).x+" "+pairs.get(0).y);
}