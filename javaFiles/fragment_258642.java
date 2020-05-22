class MyAction extends DynamicAction {
    public MyAction(String name) {
        super(name);
    }
}

@Test
public void test() {
    Map<Pair<String, MyAction>, Double> Q = new Hashtable<Pair<String, MyAction>, Double>();
    Pair<String, MyAction> pair1 = new Pair<String, MyAction>(
            "Play Cell", new MyAction("something1"));
    Pair<String, MyAction> pair2 = new Pair<String, MyAction>(
            "Play Cell", new MyAction("something2"));

    // different hashcodes
    System.out.println(pair1.hashCode());
    System.out.println(pair2.hashCode());
    Q.put(pair1, 1d);
    Q.put(pair2, 1d);
    // so the size is 2
    System.out.println(Q.size());

    // however, we can change the hashcode of the key afterwards
    System.out.println("Setting attributes");
    pair2.getSecond().setAttribute(DynamicAction.ATTRIBUTE_NAME, "something1");
    for (Object o : Q.keySet()) {
        Pair p = (Pair) o;
        System.out.println(p.hashCode());
    }
    // and the size is still 2
    System.out.println(Q.size());
}