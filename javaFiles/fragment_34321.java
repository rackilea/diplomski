public static void main(String[]args) throws InterruptedException {
    final Friend alphonse = new Friend("alphonse");
    final Friend gaston = new Friend("gaston");

    // instantiate the runner early
    Runnable gastonRunner = () -> gaston.bow(alphonse);

    new Thread(new Runnable(){
        @Override
        public void run()
        {
            alphonse.bow(gaston);
        }
    }).start();


    new Thread(gastonRunner).start();
}