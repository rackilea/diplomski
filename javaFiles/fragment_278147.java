private final Collection<Long> processingAccounts = 
       Collections.newSetFromMap(new ConcurrentHashMap<Long, Boolean>());
    ...
    @Override public boolean onPreDelete(final PreDeleteEvent preDeleteEvent) 
       throws HibernateException  {
         ....
    } else if (preDeleteEvent.getEntity() instanceof AccountEntry) {
           // check if it's already been processed
           if (processingAccounts.contains(preDeleteEvent.getEntity().getId()) 
              return false;
           // block it by ID
           processingAccounts.add(preDeleteEvent.getEntity().getId();
           try {

             ....
           } finally {
              // release
              processingAccounts.remove(preDeleteEvent.getEntity().getId()
           }
    }
    return false;
}