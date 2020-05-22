public class YourClass {
    private EntityManager em = ...; // local entity manager

    public void method(Entity e) { // only entity given here
        Entity localEntity = em.find(Entity.class, e.getId());
        EntityTransaction et = em.getTransaction();
        et.begin();
        ...
        // apply some modifications to the local entity's fields
        applyChanges(localEntity);
        ...
        try {
            et.commit();
            // Changes were successfully commited to the database. Also apply
            // the changes on the original entity, so they are visible in GUI.
            applyChanges(e);
        } catch (Exception ex) {
            et.rollback();
            // original entity e remains unchanged
        }
    }

    private void applyChanges(Entity e) { 
        ... 
    }
}