@Transactional(readOnly = true)
public void streamTest() {
ForkJoinPool customThreadPool = new ForkJoinPool(20);
try {
customThreadPool.submit(() -> {
    TransactionSynchronizationManager.setActualTransactionActive(true);
    TransactionSynchronizationManager.setCurrentTransactionReadOnly(true);
    TransactionSynchronizationManager.initSynchronization();
     priceRepository.streamAll()
     .parallel()
     .map(p -> this.transform(p))
     .forEach(System.out::println);
     }).get();
} catch (InterruptedException | ExecutionException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}