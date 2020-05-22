public static <In, Out> List<Out> map(List<In> in, Func<In, Out> f) {
    List<Out> out = new ArrayList<Out>(in.size());
    for (In inObj : in) {
        out.add(f.apply(inObj));
    }
    return out;
}
// ...
List<String> myList = ...;
List<String> lowerCased = map(myList, new Func<String, String>() {
    public String apply(String in) {
        return in.toLowerCase();
    }
});