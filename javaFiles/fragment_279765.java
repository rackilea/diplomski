class Example {

    @Test
    public void workingTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
        EntityManager em = emf.createEntityManager();

        // Creating three states
        State alabama = new State(state: 'Alabama');
        State louisiana = new State(state: 'Louisiana');
        State texas = new State(state: 'Texas');
        em.getTransaction().begin();
        em.persist(alabama);
        em.persist(louisiana);
        em.persist(texas);
        em.getTransaction().commit();

        List<State> states = em.createQuery('FROM State').getResultList();

        // Assert only three states on DB
        assert states.size() == 3;

        User userFromAlabama = new User();
        User userFromAlabamaAndTexas = new User();

        em.getTransaction().begin();
        State alabamaFromDB = em.find(State, alabama.getId());
        State texasFromDB = em.find(State, texas.getId());
        userFromAlabama.getStates().add(alabamaFromDB);
        userFromAlabamaAndTexas.getStates().add(alabamaFromDB);
        userFromAlabamaAndTexas.getStates().add(texasFromDB);

        em.persist(userFromAlabama);
        em.persist(userFromAlabamaAndTexas);
        em.getTransaction().commit();

        states = em.createQuery('FROM State').getResultList();

        // Assert only three states on DB again
        assert states.size() == 3;

        // Assert one user
        User userFromDB = em.find(User, userFromAlabama.getId());
        assert userFromDB.getStates().size() == 1;

        userFromDB = em.find(User, userFromAlabamaAndTexas.getId());
        assert userFromDB.getStates().size() == 2;
    }
}

@Entity
@Table(name="tbl_users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id

    @Column(name="user_name")
    private String name

    @ManyToMany
    private Collection<State> states = Lists.newArrayList()

    // Getters and setters
}

@Entity
@Table(name="tbl_states")
class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="state")
    private String state;
    // Getters and setters
}