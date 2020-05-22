class AnalysisInitialiser extends Thread {

        private CountDownLatch cancelLatch = new CountDownLatch(1);
        private SpecialAnalysis analysis = null;

        @Override
        public void run() {
            analysis = new SpecialAnalysis(params);
            cancelLatch.countDown();
        }

        public SpecialAnalysis getAnalysis() {
            cancelLatch.await();
            return analysis;
        }
    }