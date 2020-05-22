public class A {

    String mA;

     /* Constructor initilaizes the instance members */
     public A (String mA) { 
         this.mA = mA;
     } 

     /* this is parameterized method that takes mB as input
        and helps you operate on the object that has the instance
        member mA */

     public String doOperation (String mB) {
         return mA + " " + mB;
     }

     public static void main(String args[]) {

          /* this would call the constructor and initialize the instance variable with "Hello" */
         A a = new A("Hello");

        /* you can call the methods as many times as            you want */
        String b=  a.doOperation ("World");
        String c = a.doOperation ("How are you");

     }
}