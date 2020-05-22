public class NaiveIdentifier {
    private Set<Integer> unknowns;
    {
      Set<Integer> temp = new HashSet<Integer>() {{
        unknowns.add(0);
        // add more here.
      }};
      unknowns = temp;
    }

    public NaiveIdentifier() {} // empty default constructor
}