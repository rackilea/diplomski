// CustomView.java
public interface CustomView { }

// JpaEntity.java
@JsonView(CustomView.class)
@Column(name = "column1", length = 128, nullable = false)
private String one;

// TheController.java
// When CustomView is used you are only going to get back what's annotated
// with CustomView in the given response type (JpaEntity on this case)
@JsonView(CustomView.class)
@GetMapping(path = "{entity-id}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<?> getById(final @PathVariable("entity-id") String id, final HttpServletRequest request) {
  log.info("{} {}", request.getMethod(), request.getRequestURI());
  final Optional<JpaEntity> result = service.searchById(UUID.fromString(id));
  if (result.isPresent()) {
    return ResponseEntity.ok(result.get());
  }
  return ResponseEntity.notFound().build();
}