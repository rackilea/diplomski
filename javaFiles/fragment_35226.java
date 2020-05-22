class Entity{

    @PrePersist
    public void logChanges(){
        Change c = new Change()
        c.setEverythingXouLikeToLog();

        entityManager.persist(c);
        // don't forget ExceptionHandling
    }

}