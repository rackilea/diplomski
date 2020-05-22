@BasePathAwareController
public class CustomPersonController {

@Autowired
private ProjectionFactory factory;

@Autowired
private PersonRepository personRepository;

@Autowired
private PagedResourcesAssembler<PersonProjection> assembler;

@RequestMapping(value="/persons", method = RequestMethod.GET, produces = "application/hal+json")
public ResponseEntity<?> getPeople(Pageable pageable) {
    Page<Person> people = personRepository.findAll(pageable);
    Page<PersonProjection> projected = people.map(l -> factory.createProjection(PersonProjection.class, l));
    PagedResources<Resource<PersonProjection>> resources = assembler.toResource(projected);
    return ResponseEntity.ok(resources);
}