final ExecutorService executor = Executors.newFixedThreadPool(10);
final List<Future<Data>> list = new ArrayList<Future<Data>>(max);

for (int i = 0; i < max; i++) {
    final int tmp = i;
    Callable<Data> c = new Callable<Data>() {
        @Override
        public Data call() {
            return new Data("http://localhost/" + tmp);
        }
    };
    list.add(executor.submit(c));
}

executor.shutdown();

for (Future<Data> future : list) {
    Data data = future.get(); //will block until the page has been downloaded
    //use the data
}