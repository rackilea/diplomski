HibernateUtil.pushFlushMode(FlushMode.MANUAL);
try {
  int batchIndex = 0;
  int numAttempts = 0;
  while (batchIndex < list.size()) {
    listEnd = batchIndex+BATCH_SIZE;
    if(listEnd > list.size()) {
      listEnd = list.size();
    }
    ArrayList<> sublist = new ArrayList<>(list.subList(batchIndex, batchIndex+BATCH_SIZE));
    getCurrSess().beginTransaction();
    try {
      for(Object obj : list) {
        //Here multiple things can happen like selects, save, update, and deletes
      }
      getCurrSess().flush();
      getCurrSess().commit();
      batchIndex += BATCH_SIZE;
    } catch (Exception e) {
      getCurrSess().getTran().rollback();
      numAttempts++;
      if(numAttempts == MAX_ATTEMPTS) {
        throw new RuntimeException("Exceeded maximum number of attempts for batch operation, database is corrupted.");
      }
    }
  }
} finally {
  HibernateUtil.popFlushMode();
}