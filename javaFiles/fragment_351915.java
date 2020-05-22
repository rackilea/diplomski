public class Stuff {

  static final List<Stuff> list = Collections.synchronizedList(new ArrayList<Stuff>());
  static final CountDownLatch cdl = new CountDownLatch(1);

  @Override protected void finalize() {
    list.add(this);
    cdl.countDown();
  }

  public static void main(String[] args) throws Exception {
    list.add(new Stuff());
    list.remove(0);
    System.gc();
    System.gc();
    cdl.await();
    System.out.println(list.size());
  }
}