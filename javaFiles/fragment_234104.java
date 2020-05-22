public class Enemy implements ActionListener {
    private static int nextID = 0;
    private final int id; /* final members must be set in the constructor and cannot be changed afterward */
    public int enemyhp=3;
    /* ... */

    public Enemy(){
        id = nextID++;
        /* ... */
    }

    public String toString() {
        return "Enemy " + id + ": enemyhp=" + enemyhp;
    }

    public void actionPerformed(ActionEvent event) {
        move();
        System.out.println(toString());
    }

    /* ... */
}