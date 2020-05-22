public abstract class Abs {

    private Map<Object, Object> map;

    protected Abs(Map<Object, Object> map) {
        this.map = map;

        //you can even validate:
        if(null == this.map) throw new IllegalArgumentException("...");
    }
}

public class classA extends Abs {
    public classA() {
        super(new HashMap<Object, Object>());
    }
}

//all other subclasses follow the same logic