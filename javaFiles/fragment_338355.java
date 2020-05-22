public static void main(String args[]) throws IOException, SaxonApiException {
    Producer producer = new Producer();
    new Thread()
    {
        public void run() {
            try {
                producer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }.start();

    new Thread()
    {
        public void run() {

            try {
                producer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }.start();
}