List<Integer> nomero = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3));
Collections.sort(nomero);
for (int i = 0; i < nomero.size(); i++) {
    if (i > 0 && nomero.get(i - 1) != nomero.get(i)) {
        System.out.println();
    }
    System.out.println(nomero.get(i));
}