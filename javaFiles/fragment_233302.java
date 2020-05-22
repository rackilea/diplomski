final Solver solver = new Solver();
Schedular schedular = new Schedular(solver);
final Timer timer = new Timer();
timer.schedule(schedular, 0, TimeUnit.MINUTES.toMillis(1));

ExecutorService executor = // get a executor somehow
final Future<Double> future = executor.submit(solver);
final Double answer = future.get();
System.out.println(answer);