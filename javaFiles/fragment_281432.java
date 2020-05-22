EntityManagerFactory emf;
List<Individual> list;
Map<Integer, Individual> map;

@Setup
public void setUp() {
    emf = Persistence.createEntityManagerFactory("postgres");
    list = new ArrayList<Individual>();
    map = new HashMap<Integer, Individual>();

    for (int i = (int)1e5; i > 0; i--) {
        Individual individual = new Individual(i);
        list.add(individual);
        map.put(i, individual);
    }
}

@TearDown
public void tearDown() {
    emf.close();
}

@Benchmark
@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public Individual measureJpa() {
    EntityManager em = emf.createEntityManager();

    Query query = em.createQuery("select i from com.company.Individual i where i.id = 1");

    em.getTransaction().begin();

    Individual individual = (Individual) query.getSingleResult();

    em.getTransaction().commit();

    em.close();

    return individual;
}

@Benchmark
@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public Individual measureList() {
    for (Individual i : list) {
        if (i.id == 1) {
            return i;
        }
    }
    throw new RuntimeException();
}

@Benchmark
@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public Individual measureMap() {
    return map.get(1);
}