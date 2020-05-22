public static <T> List<T> reverse(List <T> input) {
    ListIterator<T> iterator = input.listIterator(input.size());
    ListIterator<T> reversedIterator = input.listIterator();
    for (int i=0; i<input.size()/2; i++) {
        T previous = iterator.previous();
        T next  = reversedIterator.next();
        iterator.set(next);
        reversedIterator.set(previous);
    }
    return input;
}