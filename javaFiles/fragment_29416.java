Deque<Integer> d = new LinkedList<Integer>() {
    @Override
    public boolean add(Integer integer) {
        if (integer % 2 == 1) {
            super.addLast(integer);
        } else {
            super.addFirst(integer);
        }
        return true;
    }
};

d.add(10);
d.add(3);
d.add(5);
d.add(6);
d.add(15);

System.out.println(d);