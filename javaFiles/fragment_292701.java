public static <T> void applyToListInPlace(List<T> list, Func<T, T> f) {
    ListIterator<T> itr = list.listIterator();
    while (itr.hasNext()) {
        T output = f.apply(itr.next());
        itr.set(output);
    }
}
// ...
List<String> myList = ...;
applyToListInPlace(myList, new Func<String, String>() {
    public String apply(String in) {
        return in.toLowerCase();
    }
});