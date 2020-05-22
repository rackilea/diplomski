@Repository("PersonDAO")
 public class PersonDaoImpl extends GenericDaoImpl<Person> implements PersonDao {

      @PostConstruct
      public void init(){
         super.setClazz(Person.class);
      }
 }