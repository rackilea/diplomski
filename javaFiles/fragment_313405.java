default <T extends K> Validation<T> and(Validation<T> other) {
    return param -> {
        ValidationResult firstResult = this.test(param);
        return ! firstResult.isValid()? firstResult: other.test(param);
    };
}