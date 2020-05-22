ArrayList list1 = new ArrayList();
    Random rnd = new Random();
    for (int i = 0; i < 7; i++) {
        ArrayList list2 = new ArrayList();
        while(list2.size() != 100) {
            int num = rnd.nextInt(101);
            if( num == 0 || list2.contains(num)) {
                continue;
            }
            list2.add(num);
        }
        list1.addAll(list2);
    }
    System.out.println(list1.size());