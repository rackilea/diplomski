@Service
public class SneakerService {    

   @Autowired
   SneakerRepository repository;

    public List<Sneaker> getSneakers(Optional<List<BrandType>> brands, Optional<List<BigDecimal>> sizes) {
             Specification<Sneaker> spec = 
                 Specifications.where(SneakerSpecifications.brandIn(brands))
                 .and(SneakerSpecifications.sizeIn(sizes));

             return repository.findAll(spec);        
        }
    }