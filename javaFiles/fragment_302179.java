final ExecutorService executorService = Executors.newSingleThreadExecutor();
    final Runnable j1 = new AbstractContinousTask(100, executorService) {
        @Override
        public void runInternal() {
            System.out.println("a");
        }
    };
    final Runnable j2 = new AbstractContinousTask(100, executorService) {
        @Override
        public void runInternal() {
            System.out.println("b");
        }
    };