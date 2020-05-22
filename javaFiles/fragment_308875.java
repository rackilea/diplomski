@Service
@Transactional
public class UserService {

    @Resource(name = "sessionFactory")
    private SessionFactory  sessionFactory;

    public void mergeWithExistingAndUpdate(final Person personFromPost) {

        Session session = sessionFactory.getCurrentSession();

        Person existingPerson = (Person) session.get(Person.class, personFromPost.getId());

        // set here explicitly what must/can be overwritten by the html form POST
        existingPerson.setName(personFromPost.getName());
        existingPerson.setEmail(personFromPost.getEmail());
        existingPerson.setDateModified(new Date());
        existingPerson.setUserModified(Utils.getCurrentUser());

        session.update(existingPerson);
    }

}