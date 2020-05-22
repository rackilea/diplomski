public static void main(String[] args) {
    List<LcPawn> pawns = new ArrayList<>(256);  // more generic type and type parameter omitted for brevity

    for (int i = 0; i < 256; i++) {
        pawns.add(new LcPawn());  // no need to specify an index, it gets added to the end by default
    }

    for (int i = 0; i < pawns.size(); i++) {
        pawns.get(i).setId(i);  // using setter method
    }

    for (int i = 0; i < pawns.size(); i++) {
        System.out.println(pawns.get(i).getId());  // using getter method
    }
}