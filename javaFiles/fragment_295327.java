public static void main(String[] args) throws InterruptedException {
    final List<Integer> list = new CopyOnWriteArrayList<Integer>();
    list.addAll(Arrays.asList(1, 2, 3));
    new Thread(new Runnable() {

        @Override
        public void run() {
            for (Integer i : list) {
                System.out.println("Iterator 1 - " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
            }
        }
    }).start();
    Thread.sleep(10);
    list.add(4);
    System.out.println("4 has been added");
    for (Integer i : list) {
        System.out.println("Iterator 2 - " + i);
    }

}