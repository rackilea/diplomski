binder.addCommitHandler(new CommitHandler()
{
    @Override
    public void preCommit(CommitEvent commitEvent) throws CommitException
    {
        String email = (String) commitEvent.getFieldBinder().getField("email").getValue();

        EntityManager em = /* retrieve your EntityManager */;

        List<?> results = em.createQuery("select idCurriculum from Curriculum where email = ?")
                            .setParameter(1, email)
                            .getResultList();

        if (results.size() > 0)
            throw new CommitException("Email already exists");
    }

    @Override
    public void postCommit(CommitEvent commitEvent) throws CommitException { }
});