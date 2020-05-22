static <T> Validation<T> and(Validation<? super T> first, Validation<? super T> second) {
    return param -> {
        ValidationResult firstResult = first.test(param);
        return ! firstResult.isValid()? firstResult: second.test(param);
    };
}