List<MyResult> results = query.list(ConstructorExpression.create(
        MyResult.class, person.name, neighbor.count()));

public class MyResult {
    private String name;
    private long count;
    public MyResult(String name, long count) {
        this.name = name;
        this.count = count;
    }
}