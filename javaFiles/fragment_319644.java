@RepositoryRestController
@RequestMapping(/project)
public class ProjectController {

    @Autowired private ProjectRepository projectRepo;
    @Autowired private ProjectRoleRepository projectRoleRepo;
    @Autowired private AccountRepository accountRepo;

    @PostMapping(Constants.PROJECTSPATH) // @PostMapping is a shortcut for @RequestMapping(method = RequestMethod.POST). path can be something like "/prj" (beginning with slash, because on class level, there is no suffix slash)
    public ResponseEntity<?> addProject(@RequestBody Project projectFromRequest, Principal principal) {
        Project project = projectRepo.save(projectFromRequest);
        Account currentAccount = accountRepo.findByUsername(principal.getName());
        ProjectRole ownerRole = new ProjectRole(project, currentAccount, ProjectRoleEnum.OWNER);
        projectRoleRepo.save(ownerRole);

        final URI uri =
                MvcUriComponentsBuilder.fromController(getClass())
                        .path("/{id}")
                        .buildAndExpand(project.getId())
                        .toUri();
        return ResponseEntity.created(uri).body(new ProjectResource(project));
    }
}