@GetMapping
@Cachable("CACHE_NAME")
public ResponseEntity<List<String>> getPeople() {
   List<String> people = peopleService.getPeople();
   return ResponseEntity.ok(people);
}