// front-end class
public class Resource {
    final ActualResource actual;

    Resource(ActualResource actual) {
        this.actual = actual;
    }
    public int getId() {
        return actual.getId();
    }
    public String toString() {
        return actual.toString();
    }
}
class ActualResource {
    int id;

    ActualResource(int id) {
        this.id = id;
    }

    int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ActualResource[id="+id+']';
    }
}