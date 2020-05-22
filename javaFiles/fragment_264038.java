public class Diagraph {

    public Diagraph(int n) {
       // Constructor code
    }


    public Digraph(In in) {
      this(in.readInt()); // Calls the constructor above. 
      int E = in.readInt();
      for (int i = 0; i < E; i++) {
         int v = in.readInt();
         int w = in.readInt();
         addEdge(v, w); 
      }
   }
}