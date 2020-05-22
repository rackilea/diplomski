abstract class Parent{
        Parent(){
            System.out.println("Parent contructor!");
        }
    }


    public class Child extends Parent{

        public Child() {
            super();
            System.out.println("Child contructor!");
        }

        public static void main(String[] args) {
            new Child();
        }
    }