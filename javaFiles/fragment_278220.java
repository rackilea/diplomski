public class example1
{
    private String name;
    int number;

    public example1(String names) {
        name = names;
    }

    public void setName(String names) {
        name = names;
    }

    public String getName() {
        return name;
    }
}

public class example2 extends example1
{
    public example2(String names) {
        super(names);
    }

    public void setUP(int z) {
        number = z;
    }

    public String toString() {
        return String.format("Name: %s\n Number: %s", getName(), number);
    }
}