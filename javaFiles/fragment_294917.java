public class Foo {
    public Car car1;
    public Car car2;
    public Car car3;
    public Car car4;
    public Car car5;

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 1; i <= 5; i++) {
            builder.append(Foo.class.getField("car" + i).get(this).toString());
        }
        return builder.toString();
    }
}