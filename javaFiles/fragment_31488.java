class Type {}

// create some classes based on Type
class Car extends Type {}
class Bike extends Type {}
class Boat extends Type {}

@Data
class MyOwnType<T1 extends Type, T2 extends Type > {
    private String name;
    private T1 field1;
    private T2 field2;
}

public class SomeClass {

    public static <T1 extends Type, T2 extends Type> MyOwnType<T1, T2> createMyOwnType(String name) {
        MyOwnType<T1, T2> result = new MyOwnType<>();
        result.setName(name);
        return result;
    }

    public static void main(String[] args) {
        MyOwnType<Car, Boat> sample1 = createMyOwnType("orange");
        Car car = sample1.getField1();
        Boat boat = sample1.getField2();

        MyOwnType<Boat, Bike> sample2 = createMyOwnType("red");

    }
}