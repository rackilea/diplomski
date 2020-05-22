class MyClass {
    String string;

    public MyClass(String string) {
        super();
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "MyClass [string=" + string + "]";
    }

}

public class Main {
    public static void main(String[] args) {
        final MyClass obj = new MyClass("Test");
        System.out.println(obj);
        obj.setString("Testing");
        System.out.println(obj);

        // obj= new MyClass("Testing"); // Trying to assign a new value to obj will result in a compilation error
    }
}