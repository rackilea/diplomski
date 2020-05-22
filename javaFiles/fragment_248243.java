ExecutorService e1 = Executors.newSingleThreadExecutor();
ExecutorService e2 = Executors.newSingleThreadExecutor();
e1.execute( new ExpressTask() );
e2.execute( new SequentialTask("Part-One"));
e2.execute( new SequentialTask("Part-Two"));
e2.execute( new SequentialTask("Part-Three"));
e1.shutdown();
e2.shutdown();