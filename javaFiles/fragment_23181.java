IntStream.range(0, 1000).forEach(i->service.submit(incr));
    service.shutdown();

    try {
        service.awaitTermination(1000, TimerUnit.SECONDS);
    } catch (InterruptedException e){}

    System.out.println(count);