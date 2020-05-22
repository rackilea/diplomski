public class HelloPromiseModule extends ReactContextBaseJavaModule {
    public HelloPromiseModule(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return "HelloPromise";
    }

    @ReactMethod
    public void foobar(Promise promise){
        Random r = new Random();
        final int timeToSleep = r.nextInt(1000);
        runThreadAndCallPromiseToJavascript(timeToSleep, promise);
    }
    //Cria um thread pra executar algo em paralelo
    private void runThreadAndCallPromiseToJavascript(final int timeToSleep,final Promise promise){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(timeToSleep);
                    MyData result = MyData.build(timeToSleep);
                    promise.resolve(result.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    promise.reject(e);
                }
            }
        });
        t.run();
    }
}