int first_number = 20;
    int second_number = 20;

    Optional<Integer> dummy = Optional.of(0); // Dummy allowing to call filter on the Optional
    Predicate<Integer>isAbundant = i -> first_number > second_number; // Check if input is abundant
    Predicate<Integer> isPerfect = i -> first_number == second_number; // Check if input is perfect
    Supplier<String> other = () -> dummy.filter(isAbundant).map(i -> "ABUNDANT").orElse("DEFICIENT"); // Fallback, if input is not perfect. Check for abundant or return default
    Supplier<String> validate = () -> dummy.filter(isPerfect).map(i -> "PERFECT").orElse(other.get()); // Check if input is perfect or use fallback

    return validate.get();