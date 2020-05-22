class Main {

    public static void main(String[] args) {
        Foo foo = new Foo();
        FutureTask<String> fooFutureTask = new FutureTask<>(foo);
    }
}

class Foo implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Calling";
    }
}