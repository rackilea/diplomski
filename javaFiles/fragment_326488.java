@DeleteMapping("/candidates/{id}")
public ResponseEntity<Void> deleteCandidate(@PathVariable int id) {
    try{
        candidateService.deleteById(id);
    } catch(ResourceNotFoundException e) {
       ResponseEntity.notFound().build()
    }
    return ResponseEntity.noContent().build();
}