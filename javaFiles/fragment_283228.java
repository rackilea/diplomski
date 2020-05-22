public static ArrayList<Integer> createPerm() {
    ArrayList<Integer> list = new ArrayList<Integer>(10);
    for (int i = 0; i < 10; i++) {
        list.add(i+1);
    }

    ArrayList<Integer> perm = new ArrayList<Integer>(10);

    while (!list.isEmpty()) {
        int r = (int) (Math.random() * 10) + 1;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).intValue() == r) {
                perm.add(list.remove(j));
            }
        }
    }

    return perm;
}