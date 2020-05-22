public class MyClass implements Differenceable {
    int x;
    ...

    public List<Difference> differences(Object obj) {
        List<Difference> diffs = new ArrayList<>();
        if (!(obj instanceof MyClass)) {
             diffs.add(new Difference<>(this, obj, "types differ");
        } else {
             MyClass other = (MyClass) obj;
             if (this.x != other.x) {
                 diffs.add(new Difference<>(this, obj, "field 'x' differs");
             }
             // If fields of 'this' are themselves differenceable, you could
             // recurse and then merge the result lists into 'diffs'.
        }
        return diffs;
    }
}