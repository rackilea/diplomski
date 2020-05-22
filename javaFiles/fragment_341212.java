// later on at the persist stage..
// assuming all relations between the entities are still filled in (not set to null)

// persisting the new fragment
entityManager.persist(fragment);

// persisting the new call
entityManager.persist(call);