@Controller
@RequestMapping("/entities")
public final class TheController {
  private static final Logger log = LoggerFactory.getLogger(TheController.class);

  private final TheService service;

  public TheController(final TheService service) {
    this.service = service;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Collection<JpaEntity>> getAll(final HttpServletRequest request) {
    log.info("{} {}", request.getMethod(), request.getRequestURI());
    return ResponseEntity.ok(service.searchAll());
  }

  @GetMapping(path = "{entity-id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getById(final @PathVariable("entity-id") String id, final HttpServletRequest request) {
    log.info("{} {}", request.getMethod(), request.getRequestURI());
    final Optional<JpaEntity> result = service.searchById(UUID.fromString(id));
    if (result.isPresent()) {
      return ResponseEntity.ok(result.get());
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> post(@RequestBody @Valid final JpaEntity body, final HttpServletRequest request) {
    log.info("{} {}", request.getMethod(), request.getRequestURI());
    final URI uri = URI.create(String.format("%s/%s", request.getRequestURI(), service.save(body).getId())).normalize();
    return ResponseEntity.created(uri).build();
  }
}