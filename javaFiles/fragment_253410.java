Account a = em.merge(account);
 final JpaEntityManager jpaEntityManager = (JpaEntityManager) em.getDelegate();
 final UnitOfWorkChangeSet changeSet = jpaEntityManager.getUnitOfWork().getCurrentChanges();
 final ObjectChangeSet accountChangeSet = changeSet.getObjectChangeSetForClone(a);
 final ObjectChangeSet userChangeSet = changeSet.getObjectChangeSetForClone(a.getUser());
 em.clear();
 //checks only for these 2 specific fields; changeSet.hasChanges() would check for all changes
 return accountChangeSet.hasChangeFor("credits") || userChangeSet.hasChangeFor("name");