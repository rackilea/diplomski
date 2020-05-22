public class SomeDao {
    private final EntityManagerFactory entityManagerFactory;

    public SomeDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<ExamSkeleton> getAllSkeletons() {
        try {
            TypedQuery<ExamSkeleton> query = entityManager.createQuery("SELECT NEW ExamSkeleton (s.id, s.filename, s.course, s.visible) FROM ExamSkeleton as s", ExamSkeleton.class);

            List<ExamSkeleton> skeletons = query.getResultList();

            return skeletons;
        } catch (IllegalArgumentException exception) {
            LOGGER.error(exception);
        }
            return Collections.emptyList();
    }
}