@Repository
@Transactional
public class TestEntityHibernateDAO extends AbstractHibernateDAO<TestEntity> {

    public TestEntityHibernateDAO() {
        super(TestEntity.class);
    }

}