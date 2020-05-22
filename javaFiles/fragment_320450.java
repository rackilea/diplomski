public interface CompanyRepository extends MongoRepository<Company,String>
{

}

...

@Autowired
CompanyRepository repository

public void createCompany(String name, List<Person> persons)
{
    Company company = new Company();
    company.setName(name);
    company.setPersonnel(persons);
    repository.save(company);
}