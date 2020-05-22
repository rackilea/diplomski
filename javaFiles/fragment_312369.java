class A{
    private Behavior b; //behavior which is free to change
    public void modifyBehavior(Behavior b){
         this.b = b;
    }
    public  void behave(){
          b.behave(); // there is no constraint of a specific implementation but any implementation of Behavior is allowed.
     }
 }

 class BX implements Behavior {
     public void behave(){
           //BX behavior
     }
 }

 class BY implements Behavior {
     public void behave(){
           //BY behavior
     }
 }

interface Behavior {
      void behave();
}