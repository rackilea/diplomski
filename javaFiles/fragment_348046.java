@RestController
public class SomeController {

    @Autowired
    private SomeService someService;

    @PostMapping("/parents/{parentEntityId}/childs")
    public ResponseEntity<Void> save(@PathVariable("parentEntityId") Long parentEntityId, @RequestBody ChildDto childDto) {
            someService.saveChild(parentEntityId, childDto);
            return ResponseEntity.created(...).build();
    }
}

public class SomeServiceImpl {

    @Autowired
    private ParentEntityRepository parentEntityRepository;

    @Autowired
    private ChildEntityRepository childEntityRepository;

    public ChildEntity saveChild(final long parentEntityId, final ChildDto childDto){
        ChildEntity childEntity = childDtoMapper.fromDto(childDto);
        Optional<ParentEntity> parentEntity = parentEntityRepository.findById(parentEntityId);
        if (parentEntity.isPresent()) {
            childEntity.setParent(parentEntity.get());
            childEntityRepository.save(childEntity);
            return childEntity;
        }
        throw new EntityNotFoundException("Parent entity not found!");
    }
}