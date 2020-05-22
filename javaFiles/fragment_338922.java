public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1, 3, 2, 4));
    ArrayList<Integer> c = new ArrayList<>(Arrays.asList(4, 2, 3, 1));

    for (int i = 0; i < a.size(); i++) {
        if ((!a.get(i).equals(b.get(i))) || (!a.get(i).equals(c.get(i)))) {
            b.set(i, a.get(i));
            c.set(i, a.get(i));
        }
    }

    System.err.println(Arrays.toString(b.toArray()));
    System.err.println(Arrays.toString(c.toArray()));
}