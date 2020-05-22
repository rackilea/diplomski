@Mock
Foo fooMock;

@Test
public void run() {
    Processor processor = new Processor(fooMock);
    ExecutorService executor = Executors.newCachedThreadPool();
    executor.execute(processor);
    executor.awaitTermination(someTime, TimeUnit.SECONDS);
    Mockito.verify(fooMock).sendRequest(...);   
}