public class Blocks {
public static Block[] b = new Block[8];

static {
   // Instantiating the objects present in the array
   for(int i=0; i<b.length; i++)
       b[i] = new Block();
}

public Blocks() throws IOException {
   // Now you can access them
    new Air  (b[0]);
    new Stone(b[1]);
    new Grass(b[2]);
    new Dirt (b[3]);
}