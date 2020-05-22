class Mailer {
    private final ExecutorService executor = Executors.newFixedThreadPool(maxMailingThreads);
    //...
        public void doMail(MailTask anEmail) {
            Future<MailTaskResult> future = executor.submit(new MailTask(anEmail));
            future.get().isSuccessful(); // handle success or failure somehow
        }