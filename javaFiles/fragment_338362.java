@Stateless
@LocalBean
public class PersonService {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private AgeCategoryFacade ageCategoryFacade;

    public Person updatePerson(Person person) {
         // use ageCategoryFacade somehow to set ageCategory for example:
         String ageCategory = ageCategoryFacade.getAgeCategory(person.getAge());
         person.setAgeCategory(ageCategory);
         return (Person) em.merge(person);
    }
}