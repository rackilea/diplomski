for (int i = 0; i < 240; i+=8) {
    // this sub list is backed by the orders list, so you should be careful
    // if you need to alter the sub list.
    final List<Integer> subList = orders.subList(i, i+8); 
    final List<Integer> subListThatAllowsLocalModifications =
            new ArrayList<Integer>(subList);
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println(subList);
        }
    });
    t.start();
}