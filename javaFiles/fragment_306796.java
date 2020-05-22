@Service
@Transactional
public class CompanyService {

    private final CompanyRepo companyRepo;

    public CompanyService(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    public Company create(CompanyDto dto) {
        Company company = dto.toCompany();
        // Some custom logic...
        return companyRepo.save(company);
    }
}