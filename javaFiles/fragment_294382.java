import java.util.Random;

public class Example {
    private String name;
    private int x;
    private int y;

    {                                     // This is the
        this.x = new Random().nextInt();  // instance
        this.y = this.x * 2;              // initializer
    }                                     // block

    public Example() {
        this.name = null;
    }

    public Example(String name) {
        this.name = name;
    }
}