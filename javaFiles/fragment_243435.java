public List<Supplier<String>> getData(ClassA instance) {
    return Arrays.asList(
        instance::getOne,
        instance::getTwo
    );
}