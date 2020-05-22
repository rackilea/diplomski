public static List<Integer> intersection(List<Integer> A, List<Integer> B) {
    List<Integer> result = new ArrayList<Integer>();

    int i = 0;
    int j = 0;

    while (i != A.size() && j != B.size()) {
        if (A.get(i) < B.get(j)) {
            i++;
        }

        else if (A.get(i) > B.get(j)) {
            j++;
        }

        else {
            // If already contains item dont add again
            if (!result.contains(A.get(i))) {
                result.add(A.get(i));
            }
            i++;
            j++;
        }

    }

    return result;
}

public static void main(String[] args) {
    List<Integer> r = intersection(Arrays.asList(2, 2, 2, 3), Arrays.asList(2, 2, 3, 4));
    System.out.println(r);
}