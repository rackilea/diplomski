public class MySpringPojoDAO extends JdbcDaoSupport implements IMySpringPojoDAO {

    @Autowired
    public MySpringPojoDAO (DataSource dataSource){
        setDataSource(dataSource); // JdbcDaoSupport#setDataSource(..)
    }

    [...]

 }