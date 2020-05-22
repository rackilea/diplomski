Arraylist<C> ListC = new ArrayList<>();

for (int i = 0; i < ListB.size(); i++) {
    // initially, assume that this element is not contained in ListA
    boolean contained = false;

    // check if this element is contained in ListA
    for (int j = 0; j < ListA.size(); j++) {
        if (ListA.get(i).getName().equals(ListB.get(j).getName())) {
            contained = true;
        }
    }

    // if this element is not contained once in ListA,
    if (!contained) {
        // add it to ListC
        C c = new C();
        c.setName(b.get(j).getName());
        ListC.add(c);
    }
}