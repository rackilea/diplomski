public ArrayList getVector3f() {
    // create first random vector & add it to the list array
    Vector3f vec = randVector();
    list.add(vec);

    for (int i = 0; i <= num-2; i++) {
        boolean lessThan = true;
        while (lessThan) {
            lessThan = false;
            vec = randVector();
            for (int j = 0; j < list.size() ; j++) {
                if (list.get(j).distance(vec) < 4f) {
                    lessThan = true;
                    break;
                }
            }
        }
        list.add(vec);
        System.out.println(vec);
    }
    return list;
}