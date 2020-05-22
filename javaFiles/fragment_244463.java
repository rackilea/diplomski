@Repository
public class SomeDaoImpl {

@Autowired
@Qualifier("XyzDataSource")
DataSource dataSource;

@Override
public List <String> create(Employee request) {

    Connection conn = null;
    conn = dataSource.getConnection();