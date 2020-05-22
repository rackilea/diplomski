public static void main(String[] args) {
        List<String> letter = Arrays.asList("A", "B", "C", "D", "E");
        List<String> res = new ArrayList<>();
        res.addAll(letter);
        int size = 2;

        for (int i = 1; i < size ; i++) {
            res = addLetter(res, letter);   //add a letter to all
        }

        res.forEach(p -> System.out.println(p));
}

public static List<String> addLetter(List<String> already, List<String> letters) {
    List<String> res = new ArrayList<>();

    for (String al : already) {
        for (String let : letters) {
            if (!al.contains(let)) {
                res.add(al + let);
            }
        }
    }
    return res;
}