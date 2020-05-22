public class EnumUrl {

private Set<String> enumeration = null;
private List<String> data = null;
private final String baseUrl = "http://localhost:8080/service/USERID=101556000/";

public EnumUrl(List<String> d) {
    data = d;
    enumeration = new HashSet<String>(); // choose HashSet : handle duplicates in the enumeration process
}

public Set<String> getEnumeration() {
    return enumeration;
}

public static void main(String[] args) {

    List<String> data = new ArrayList<String>();
    data.add("A");
    data.add("B");
    data.add("C");

    EnumUrl enumerator = new EnumUrl(data);

    for (int k = 0; k < data.size(); k++) {

        // start from any letter in the set
        for (int i = 0; i < data.size(); i++) {
            // enumerate possible url combining what's on the right of indice i
            enumerator.enumeratePossibleUrlsToRight(data.get(i), i);

            // enumerate possible url combining what's on the left of indice i
            enumerator.enumeratePossibleUrlsToLeft(data.get(i), i);
        }

        // make a circular permutation of -1 before the new iteration over the newly combined data
        enumerator.circularPermutationOfData();
    }

    // display to syso
    displayUrlEnumeration(enumerator);
}

private void circularPermutationOfData() {
    String datum = data.get(0);
    for (int i = 1; i < data.size(); i++) {
        data.set(i - 1, data.get(i));
    }
    data.set(data.size() - 1, datum);
}

private static void displayUrlEnumeration(EnumUrl enumerator) {
    for (String url : enumerator.getEnumeration()) {
        System.out.println(url);
    }
}

private void enumeratePossibleUrlsToRight(String prefix, int startAt) {
    enumeration.add(baseUrl + prefix);
    if (startAt < data.size() - 1) {
        startAt++;
        for (int i = startAt; i < data.size(); i++) {
            int x = i;
            enumeratePossibleUrlsToRight(prefix + "," + data.get(x), x);
        }
    }
}

private void enumeratePossibleUrlsToLeft(String prefix, int startAt) {
    enumeration.add(baseUrl + prefix);
    if (startAt > 0) {
        startAt--;
        for (int i = startAt; i >= 0; i--) {
            int x = i;
            enumeratePossibleUrlsToLeft(prefix + "," + data.get(x), x);
        }
    }
}
}