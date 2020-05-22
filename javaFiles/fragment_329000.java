public class Test {
    {
        class People {            
        }

        People people = new People();
        System.out.println("In initializer block!");
    }

    public static void main(String[] args) {
        new Test();
    }
}