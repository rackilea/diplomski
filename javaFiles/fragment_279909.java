public interface Visitor<T> {
    // returns true if visiting should be cancelled at this point
    boolean accept(Node<T> node);
}

public class Node<T> {
    ...

   // returns true if visiting was cancelled
   public boolean visit(Visitor<T> visitor) {
       if(visitor.accept(this))
           return true;
       for(Node<T> child : children) {
           if(child.visit(visitor))
               return true;
       }
       return false;
   }
}