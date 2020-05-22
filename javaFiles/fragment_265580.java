ThreadPoolExecutor exec = new ThreadPoolExecutor(
        0, 64, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
exec.allowCoreThreadTimeOut(true);

Scheduler s = Schedulers.from(exec);

Observable
.from(Arrays.asList("one", "two", "three"))
.doOnNext(word -> System.out.printf("%s uses thread %s%n", word,
    Thread.currentThread().getName()))
.subscribeOn(s)
.subscribe(word -> System.out.println(word));