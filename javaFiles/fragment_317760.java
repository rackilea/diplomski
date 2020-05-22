public class NaiveIdentifier {
    private Set<Integer> unknowns = new HashSet<Integer>() {{
        // yeah, we saved writing the nine characters "unknowns."
        add(0);
        // add more here.
    }};

    public NaiveIdentifier() {} // empty default constructor
}