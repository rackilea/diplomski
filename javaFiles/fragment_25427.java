CountDownLatch l = new CountDownLatch(1);
Observable.just(1, 2, 3)
          .zipWith(Observable.interval(1000L, TimeUnit.MILLISECONDS), (x, y) -> x)
          .subscribe(
              System.out::println,
              Throwable::printStackTrace,
              () -> {
                  System.out.println("Done. ");
                  l.countDown();
              }
          );

l.await();