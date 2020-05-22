public static void main(String[] args) {
    List<String> letters = Arrays.asList("A", "B", "C", "D", "E");
    List<String> res = new ArrayList<>();

    for (String al : letters) {
        for (String let : letters) {
            if (!al.contains(let)) {
                res.add(al + let);
            }
        }
    }
    res.forEach(p -> System.out.println(p));
}