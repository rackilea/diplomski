@FunctionalInterface
public interface Validation<K> {
    ValidationResult test(K item);

    default <T extends K> Validation<T> and(Validation<T> other) {
        return and(this, other);
    }
    static <T> Validation<T> and(Validation<? super T> first,Validation<? super T> second){
        return param -> {
            ValidationResult firstResult = first.test(param);
            return ! firstResult.isValid()? firstResult: second.test(param);
        };
    }
}