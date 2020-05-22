public interface TypedKey<T, K extends TypedKey<T, K>> {

}

public class Map<K extends Key<K>> {

    <T, K1 extends TypedKey<T, ? extends K>> T get(K1 key) {
        return null; // TODO implementation
    }

}