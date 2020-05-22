HibernateUtil.pushFlushMode(FlushMode.MANUAL);
try {
    getCurrSess().beginTransaction();
    try {
      for(int i = 0; i < list.size(); i++) {
        Object obj = list.get(i);
        //Here multiple things can happen like selects, save, update, and deletes
        if(i % BATCH_SIZE == 0) {
          getCurrSess().flush();
        }
      }
      getCurrSess().commit();
    } catch (Exception e) {
      throw new RuntimeException("Error occurred during batch.  Batch aborted.");
    }
  }
} finally {
  HibernateUtil.popFlushMode();
}