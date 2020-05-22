public class Test {
    public static void Main(String [] args) {
        Object other = new Square();

        if (other instanceof Square)
            Square realOther = (Square) other;
        else
            Rectangle realOther = (Rectangle) other;

        return;
    }
}

class Rectangle {
    public Rectangle() { }
    public void doSomethingElse() {
        System.out.println("Something");
    }
}

class Square {
    public Square() { }
    public void doSomething() {
        System.out.println("Something");
    }
}