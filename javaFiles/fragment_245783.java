public void deleteRecord(Class classOfProduct, Object id) {

    PersistenceManager pm = PMF.get().getPersistenceManager();
    try {
            Object p = pm.getObjectById(classOfProduct, id);
            pm.deletePersistent(p);
    } finally {
            pm.close();
    }
}