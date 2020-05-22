@RequestScoped
public UserDao {

    @PersistencyContext
    private EntityManager em;

    public void addUser(User user) {
        em.save(user);
    }
}