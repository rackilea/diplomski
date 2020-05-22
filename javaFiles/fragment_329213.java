public class Y extends X {

    public void someMethod(){
        System.out.println("we are in class Y method ");
    }


    public static void main(String [] args){
        X x = new X();
        X x2 = new Y();
        Y y = new Y();

        x.someMethod();
        x2.someMethod();
        y.someMethod();
    }

}