public class AbstractBaseEntityGenericDaoTest {

    private class AbstractClassStub extends AbstractBaseEntityGenericDao {

        public AbstractClassStub(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

        @Override
        public void create(BaseEntity entity) {
            super.create(entity);
        }

        @Override
        public Optional find(long id) {
            return super.find(id);
        }

        @Override
        public void update(BaseEntity entity) {
            super.update(entity);
        }

        @Override
        public void remove(@NonNull Long id) throws EntityNotFoundException {
            super.remove(id);
        }

        @Override
        public void remove(BaseEntity entity) {
            super.remove(entity);
        }
    }

    @Mock
    SessionFactory sessionFactory;

    private AbstractClassStub abstractClassStub;

    @Before
    public void before() {
        sessionFactory = mock(SessionFactory.class);
        abstractClassStub = new AbstractClassStub(sessionFactory);
    }

    @Test
    public void testWhatever() {
        abstractClassStub.find(1); //or whatever
    }
}