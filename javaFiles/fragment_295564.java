//
// NOTE: For brevity, I'm using Java 8 syntax (lambdas and method references).
//

public static void main(String[] args) throws Throwable {
    System.out.println("Main Thread: " + Thread.currentThread().getId());

    final CountDownLatch done = new CountDownLatch(1);
    final Observable<Trade> trades = simulateTrades();

    trades.where(t -> Math.abs(t.quantity) * t.price >= 250000)
          .observeOn(Schedulers.threadPoolForIO())
          .subscribe(
              Main::logLargeTrade,
              e -> { e.printStackTrace(); done.countDown(); },
              done::countDown
          );

    done.await();
    System.out.println("Done!");
}

private static Observable<Trade> simulateTrades() {
    final Random r = new Random();

    return Observable.interval(50L, TimeUnit.MILLISECONDS)
                     .take(100)
                     .map(
                         t -> new Trade(
                             Instant.now(),
                             "AAPL",
                             (r.nextInt(9) + 1) * 100,
                             500d + r.nextDouble() * 5d
                         )
                     );
}

private static void logLargeTrade(Trade t) {
    System.out.printf(
        "[%d: %s] Large Trade: %d %s @ %f%n",
        Thread.currentThread().getId(),
        t.timestamp.atOffset(ZoneOffset.UTC).toLocalDateTime(),
        t.quantity,
        t.symbol,
        t.price
    );
}

final static class Trade {
    final Instant timestamp;
    final String symbol;
    final double price;
    final int quantity;

    Trade(Instant time, String symbol, int quantity, double price) {
        this.timestamp = time;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
    }
}