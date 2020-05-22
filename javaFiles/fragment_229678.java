private static void visual() {

        while (z < 26) {
            buttons[plaintext[p]+z*26].setBackground(Color.GREEN);
            z++;
        }

        z = 0;
        if (p < plaintext.length) p++;

}

final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
                 @Override
                 public void run() {
                         visual();
                 }
         }, 0, 1, TimeUnit.SECONDS);