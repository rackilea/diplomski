@RequestMapping(method = RequestMethod.GET)
public Callable<String> getFoobar() throws InterruptedException {
    return new Callable<String>() {
        @Override
        public String call() throws Exception {
            Thread.sleep(8000); //this will cause a timeout
            return "foobar";
        }
    };
}