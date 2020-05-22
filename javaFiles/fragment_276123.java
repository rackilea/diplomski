public class Person {
}
---------------------------------------------------------
public class Postman extends Person {
}
---------------------------------------------------------
public class Dog {
    public void barkAt(Person p) {
        System.out.println("Woof woof");
    }

    public void barkAt(Postman p) {
        System.out.println("Grrrr");
    }
}
---------------------------------------------------------
public class Rottweiler extends Dog {
    @Override
    public void barkAt(Person p) {
        System.out.println("I'm going to eat you.");
    }

    @Override
    public void barkAt(Postman p) {
        System.out.println("I'm going to rip you apart.");
    }
}