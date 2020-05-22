public class Difference {
    private Object thisObject;
    private Object otherObject;
    String difference;
    ...
}

public interface Differenceable {
    /** Report the differences between 'this' and 'other'. ... **/
    public List<Difference> differences(Object other);
}