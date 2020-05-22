//for (Integer i = 0; i < 10; i++) {
    while (!list.isEmpty()) {
        Integer r = (int) (Math.random() * 10) + 1;
        for (Integer j = 0; j <= list.size() - 1; j++) {
            //if (list.get(j) == r) {
            if (list.get(j).equals(r)) {
                //remove = j + 1;
                remove = list.get(j);
                list.remove(remove);
                perm.add(r);
            }
        }
    }