@Service
class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyDAO companyDAO;

    @Transactional
    public void addCompany(Company company) {
            companyDAO.addCompany(company); // in here, there is JDBC sql insert
            companyDAO.addCompany_fail(company); // just for test
    }
}