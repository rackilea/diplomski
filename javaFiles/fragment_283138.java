public abstract class Employee {
    public abstract void names();
    }

public class Banani extends Employee {
    @Override
    public void names() {
        System.out.println("I am at Banani.");
    }
}

public class Shyamoli extends Employee {
    @Override
    public void names() {
        System.out.println("I am at Shyamoli");
    }
}

class javatest {

    public static void main(String[] args) {
        Employee south = new Banani();
        Employee north = new Shyamoli();
        north.names();
        south.names();
    }
}