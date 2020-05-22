public abstract class Component {

     public abstract doOperation(); // still need to be implemented by subclasses


     /**
      * Empty stub method. Subclasses may override it.
      */
     public void addComponent(Component comp){
     }

     public void removeComponent(Component comp){
     }

     public Component getChild(int index){
         return null;
     }
}