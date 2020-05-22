public class Main {

        public static void main (String [] args) 
        {
            GrandParent baz = new A();
            GrandParent biz = new B();

            if (baz instanceof Parent1)
               System.out.println("hi");

            if (biz instanceof Parent1)
               System.out.println("hi again");
        }
}