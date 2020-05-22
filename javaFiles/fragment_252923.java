// method reference
stream.mapToInt(Integer::parseInt)

// lambda expression
stream.mapToInt((String value) -> Integer.parseInt(value)) // explicit parameter types
stream.mapToInt(value -> Integer.parseInt(value))          // implicit parameter types

// anonymous class
stream.mapToInt(new ToIntFunction<>() {

    @Override
    public int applyAsInt(String value) {
        return Integer.parseInt(value);
    }

})