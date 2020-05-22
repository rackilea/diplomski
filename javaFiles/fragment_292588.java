public interface Operation {
    void move();
    void delete();
    void search(String criteria);
}

public class DailyMailProcessor {
    private Operation op; 
    public DailyMailProcessor {/*instantiate op*/}
    void move() {op.move();}
}