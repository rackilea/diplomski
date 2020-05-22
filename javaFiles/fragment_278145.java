public static void main(String[] args) throws Exception {
    String[] Dog = {"Brown", "White", "Black"};
    String[] Cat = {"Brown", "White", "Red"};

    // Join the arrays together to get distinct values
    String[] join = new String[Dog.length + Cat.length];
    System.arraycopy(Dog, 0, join, 0, Dog.length);
    System.arraycopy(Cat, 0, join, Dog.length, Cat.length);
    Object[] distincts = Arrays.stream(join).distinct().toArray();

    // Rearrange data into a Map
    Map<String, List<String>> rearranged = new HashMap();
    for (Object obj : distincts) {
        rearranged.put(obj.toString(), new ArrayList());
        if (Arrays.stream(Dog).anyMatch(dt -> dt.contentEquals(obj.toString()))) {
            rearranged.get(obj.toString()).add("Dog");
        }
        if (Arrays.stream(Cat).anyMatch(dt -> dt.contentEquals(obj.toString()))) {
            rearranged.get(obj.toString()).add("Cat");
        }
    }

    // Print rearranged results
    rearranged.keySet().stream().forEach((key) -> {
        System.out.println(key + " has array " + rearranged.get(key));
    });
}