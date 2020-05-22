public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Location ob1 = new Location(10.0, 20.0);
        Location ob2 = new Location(5.0, 30.0);
        ob1.show();
        ob2.show();
        ob1 = ob1.plus(ob2);
        ob1.show();
        return;
    }
 }