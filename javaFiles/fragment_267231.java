ExecutorService es = Executors.newSingleThreadExecutor();
class Foo implements Callable<String> {
    public String call() throws Exception {
        return "success";
    }
}
// has to choose between submit(Callable) and submit(Runnable)
// given a Foo instance
Expression ex = new Expression(es, "submit", new Object[]{ new Foo() });
Future<?> f = (Future<?>)ex.getValue();
System.out.println(f.get());
es.shutdown();