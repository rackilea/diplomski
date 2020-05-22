public class Connection
   {
      private int speedKbps;
      private Node endNode;

      public Connection(Node endNode, int speedKbps)
      {
        this.endNode = endNode;
        this.speedKbps = speedKbps;
      }

      //... setters and getters
   }