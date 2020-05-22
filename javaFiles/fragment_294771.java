@Repository
public class StudentDAOImpl implements StudentDAO{

 @Autowired
 public SessionFactory sessionFactory;
 ....

 public void setSessionFactory(SessionFactory sessionFactory){
     this.sessionFactory = sessionFactory;
  }
}