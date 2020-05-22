@PostMapping("/slaves")
@Timed
public ResponseEntity<Slave> createSlave(@RequestBody Slave slave) throws URISyntaxException {
    log.debug("REST request to save Slave : {}", slave);
    if (slave.getId() != null) {
        return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("slave", "idexists", "A new slave cannot already have an ID")).body(null);
    }
    Slave result = slaveRepository.save(slave);
    Cache c = cacheManager.getCache("test.domain.Master.slaves");
    if (c != null) {
        c.removeAll();
    }
    return ResponseEntity.created(new URI("/api/slaves/" + result.getId()))
        .headers(HeaderUtil.createEntityCreationAlert("slave", result.getId().toString()))
        .body(result);
}