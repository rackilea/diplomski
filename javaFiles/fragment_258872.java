public class Tree {
    protected String name;

    public Tree() {
        this("A Tree");
    }

    protected Tree(String name) {
        this.name = name;
        System.out.println(name);
    }
}

public class Oak extends Tree {
    public Oak() {
        super("An Oak Tree");
    }
}