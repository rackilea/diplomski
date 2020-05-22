default <T extends K> Validation<T> compose(Validation<T> other) {
    return param -> {
        ValidationResult firstResult = other.test(param);
        return ! firstResult.isValid()? firstResult: this.test(param);
    };
}