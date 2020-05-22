public interface Identifiable<T extends Comparable<T>> {    
    public T getIdentifier();
}

public class Agreement implements Identifiable<Long> {

    private final Long id;

    public Long getIdentifier() {
        return id;
    }
}