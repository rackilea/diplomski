public class SomeClass implements Runnable {
    private List yourArrayList;
    public void run() {
        display();
    }

    public void display() {
        //Your display method implementation.
    }
   public List methodToGetArrayList()
   {
    return  yourArrayList;
   }
}