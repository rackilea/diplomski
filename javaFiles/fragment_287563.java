private <T> Predicate<T> reduced(List<Predicate<T>> nameAndExtension) {
    return nameAndExtension
            .stream()
            .reduce(s -> true,
                    (left, right) -> left.and(right));
}

private void test(List<Predicate<String>> nameAndExtension, List<Predicate<Long>> sizeAndDateAsLong) {

    Predicate<String> first = reduced(nameAndExtension);
    Predicate<Long> second = reduced(sizeAndDateAsLong);

    // apply the above

}