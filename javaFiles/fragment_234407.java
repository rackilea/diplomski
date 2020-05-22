static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {

        emf = Persistence.createEntityManagerFactory("unit");
        em = emf.createEntityManager();

        Employee manager = new Employee();
        manager.setId(new EmployeeId(1, 1));

        Employee e1 = new Employee();
        e1.setId(new EmployeeId(1,2));
        e1.setManager(manager);


        em.getTransaction().begin();

        em.persist(manager);
        em.persist(e1);

        em.getTransaction().commit();

        Employee e2 = em.find(Employee.class, new EmployeeId(1, 2));

        System.out.println(e2.getManager().getId().getId1() + "-" + e2.getManager().getId().getId2());
        //  prints  1-1

    }