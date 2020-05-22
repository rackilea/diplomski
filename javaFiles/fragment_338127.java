public class Composition
{
    private List<String> member;

    public Composition ()
    {
        // here you decide the type of your member during runtime
        if (someCondition) {
            member = new ArrayList<String>();
        } else {
            member = new LinkedList<String>();
        }
    }
}