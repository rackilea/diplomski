PipedOutputStream pos= new PipedOutputStream();
PipedInputStream pis = new PipedInputStream(pos);
AtomicBoolean isDone = new AtomicBoolean();
NumGen ng = new NumGen(pos, isDone);
RunningAvg ra = new RunningAvg(pis, isDone);
ng.start();
ra.start();