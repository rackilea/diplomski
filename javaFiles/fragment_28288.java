ArrayList<Callable<Collection<Address>>> tasks = new ArrayList<Callable<Collection<Address>>>();
tasks.add(new Callable<Collection<Address>>() {
  public Collection<Address> call() throws Exception {
    return BluetoothModule.scanAddresses();
  }
});
tasks.add(new Callable<Collection<Address>>() {
  public Collection<Address> call() throws Exception {
    return WiFiModule.scanAddresses();
  }
});

ExecutorService executorService = Executors.newFixedThreadPool(2);
List<Future<Collection<Address>>> futures = executorService.invokeAll(tasks);