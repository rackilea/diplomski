@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CompanyDto dto) {
        return ResponseEntity.ok(companyService.create(dto));
    }
}