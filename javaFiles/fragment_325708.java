@Module
public class PersonModule {
..
@Provides
public Person providePerson(Company company){
  return new Person(..,..,company);
}
..
}