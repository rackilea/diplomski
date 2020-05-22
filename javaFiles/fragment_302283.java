public <T> int calcSum(List<T> items, ToIntFunction<? super T> fn) {
    return items.stream()
                .mapToInt(fn)
                .sum();
}

// Example invocations:
int heightSum = calcSum(items, MyClass::getHeight);
int weightSum = calcSum(items, MyClass::getWeight);