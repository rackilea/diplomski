final List<Item> items = new ArrayList<Item>();
items.addAll(stuff);
new Thread(new Runnable() {
  public void run() {
    for (Item item: items) {
      System.out.println(item);
    }
  }
}).start();