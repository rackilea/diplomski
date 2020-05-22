public static List<Company> getAll() {
    EntityManager em = GestionFactory.factory.createEntityManager();
    Query q = em.createQuery("SELECT e.company, AVG(e.salary) FROM Employee e GROUP BY e.company");

    // each list entry contains a tuple (company, avgSalary)
    List<Object[]> results = q.getResultList();

    List<Company> companiesList = new LinkedList<>();
    for (Object[] entry : results) {
        Company company = (Company) entry[0]; // contains "e.company"
        Double avgSalary = (Double) entry[1]; // contains "AVG(e.salary)"
        company.setAverageSalary(avgSalary);
        companiesList.add(company);
    }

    return companiesList;
}