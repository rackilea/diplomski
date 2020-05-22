public class Foo {
Map<Integer, Double> data;

public Map<Integer, Double> getData() {
    return data;
}

public void setData(Map<Integer, Double> data) {
    this.data = data;
}

@Override
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (!(o instanceof Foo))
        return false;
    Foo foo = (Foo) o;
    if (this.data.size() != foo.getData().size())
        return false;

    Set<Integer> keySet1 = data.keySet();
    Set<Integer> keySet2 = foo.getData().keySet();
    // keys should same
    if (keySet1.containsAll(keySet2) && keySet2.containsAll(keySet1)) {
        // for the same key, the values are close
        for (Integer key : keySet1) {
            if (!isEntryEqual(data.get(key), foo.getData().get(key))) {
                return false;
            }
        }
        return true;
    }


    return false;
}

// also need to override the hashCode method


@Override
public int hashCode() {
    List<Integer> keys = new ArrayList<Integer>(this.data.keySet());
    return Objects.hash(keys);
}

public static final Double PRECISION = 0.0001;

private static boolean isEntryEqual(Double d1, Double d2) {
    return d1 - d2 < PRECISION;
}
}