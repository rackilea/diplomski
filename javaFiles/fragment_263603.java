public Person getProfileForCurrentUser()
{
    PersistenceManager pm = getPersistenceManager();
    try {
        Key k = getKeyForEmailAddress(getCurrentUserEmail());
        Person p = pm.getObjectById(Person.class, k);
        p.getLocationStamps().size();
        return p;
    } catch (JDOObjectNotFoundException e) {
        // Create a new profile if the new one isn't found
        return updateProfileForCurrentUser(new Person());
    } finally {
        pm.close();
    }
}