public class Mediator {
     private LinkedList<PrintWriter> connections; 

     /*** Constructor creates the list that maintains the connections */       
     public Mediator() {
         connections = new LinkedList<PrintWriter>();
     } 

     // ... Rest of class code