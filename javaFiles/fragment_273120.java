public void saveEmployee(String firstname, String lastname, List<Job> jobs) {
    Employee employee1 = new Employee();
    employee1.setFirstName(firstname);
    employee1.setLastName(lastname);
    for (Job job : jobs) {
        job.setEmployee(employee1);
    }
    employee1.setJobList(jobs);
    entityManager.persist(employee1);
}