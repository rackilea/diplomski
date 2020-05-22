//         return type                 function to map
public <U> Optional<U> map(Function<? super T, ? extends U> mapper) {
    Objects.requireNonNull(mapper); // null check 
    if (!isPresent()) {
        return empty();    // could be true when 'aa' is null in your case
    } else {
        return Optional.ofNullable(mapper.apply(value)); // using Optional.ofNullable itself
    }
 }