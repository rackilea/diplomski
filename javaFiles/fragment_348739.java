@Repository("erpDao")
@Transactional(value="txManager2")
public class ErpDaoImplementation implements ErpDao {

    private final SessionFactory sessionFactory2;

    @Autowired
    public ErpDaoImplementation(@Qualifier(value="sessionFactory2") final SessionFactory sessionFactory2) {
        this.sessionFactory2 = sessionFactory2;
    }