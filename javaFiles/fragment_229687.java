// you could even use the Function types from Guava...
interface Func<In, Out> {
    Out apply(In in);
}

// create a new "function" object in 5 lines of code:
Func<String, Integer> parseInt = new Func<String, Integer> {
    public Integer apply(String in) {
        return Integer.parseInt(in);
    }
}