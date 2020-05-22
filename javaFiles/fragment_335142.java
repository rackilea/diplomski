public final class ImmutableObject {

    private final String name;

    private final NormalObject obj =  new NormalObject();

    private final ImmutableNormalObject objFacade = new ImmutableNormalObject(obj);

    public String getName() {
        return name;
    }

    public ImmutableObject(String name) {
        this.name = name;
        obj.setName(name);
    }

    public ImmutableNormalObject getObj() {

        return objFacade;
    }
}

public class NormalObject {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class ImmutableNormalObject {

    private NormalObject obj;

    public ImmutableNormalObject(Normalobject o) {
        this.obj = o;
    }

    public String getName() {
        return obj.getName();
    }
}