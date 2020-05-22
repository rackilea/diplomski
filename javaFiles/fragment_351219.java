ExecutorService executorService = Executors.newFixedThreadPool(2);

Future<?> f1 = executorService.submit(this::method3());
Future<?> f2 = executorService.submit(this::method4());

f1.get();
f2.get();

executorService.shutdown();