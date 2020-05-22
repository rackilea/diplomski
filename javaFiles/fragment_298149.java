static {
    init();
}

private static void init() {
    Map<Integer, String> map = new HashMap<>();

    int i = 0;
    map.put(++i, "1");
    ***
    Thread foo = new Thread() {
        @Override
        public void run() {
            print(map.keySet().iterator().next()); //try access the private method, this cause a competition with **Class Initializer** and **static block**
        }
    };

    foo.start();
    try {
        foo.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
//equal to e -> {System.out.println(e);}
private static void print(int t) {
    System.out.println(t);
}