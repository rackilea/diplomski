public interface MyInterface {
    void frob();
}

public class Obj implements MyInterface {

    public void frob() {
        doFrobbing();
    }

    private void doFrobbing() {
        System.out.println("frobbing");
    }

    public static void main(String[] args) {
        MyInterface myObj = new Obj();
        myObj.frob(); // still internally calls doFrobbing()
        ((Obj)myObj).doFrobbing(); // visible only via class reference
    }
}