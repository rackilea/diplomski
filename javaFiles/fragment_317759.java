public class NaiveIdentifier {
    private Set<Integer> unknowns = new HashSet<Integer>() {{
        unknowns.add(0);
        // add more here.
    }}; // ( <- added missing brace here)

    public NaiveIdentifier() {} // empty default constructor
}