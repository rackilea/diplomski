public class Message implements Serializable {
   public int getTotalNumberOfChildren() {
       int number = 0;
       if (children != null) {
          // calculates the number of children I have plus the number of children each child has
          number = children.size();
          for(Message m : children) {
             number += m.getTotalNumberOfChildren();
          }
       }
       return number;
   }
}