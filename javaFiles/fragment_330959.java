Logger logger = LoggerFactory.getLogger(TestCase.class);
@Rule public MethodRule watchman = new TestWatchman() {
   public void starting(FrameworkMethod method) {
      logger.info("Test {} is running.", method.getName());
   }
   public void succeeded(FrameworkMethod method) {
   logger.info("Test {} succesfully run.", method.getName());
   }
   public void failed(Throwable e, FrameworkMethod method) {
        logger.error("Test {} failed with {} reason.", 
                                                method.getName(), e.getMessage());
   }
};