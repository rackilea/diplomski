AtomicLong time = new AtomicLong(1_524_567_870_569L);

    Callable<String> task = new Callable<String>(){
        @Override
        public String call() {
            return DateUtil.getTimeStampAsString(time.getAndAdd(2_768_461_000L));
        }
    };