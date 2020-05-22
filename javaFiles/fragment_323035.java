public class PersonHibernateDAO implements PersonDAO {
   public List<Person> findAll() {
      // use Hibernate to find and return all the Person objects
   }
}

public class PersonTestDAO implements PersonDAO {
   public List<Person> findAll() {
      List<Person> testData = new ArrayList<Person>();
      testData.add(new Person("Bob");
      testData.add(new Person("Steve");
      return testData;
   }
}