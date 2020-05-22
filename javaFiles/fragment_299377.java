@DeleteMapping("/slaves/{id}")
@Transactional
@Timed
public ResponseEntity<Void> deleteSlave(@PathVariable Long id) {
    log.debug("REST request to delete Slave : {}", id);
    Slave slave = slaveRepository.getOne(id);
    Cache c = cacheManager.getCache("test.domain.Master.slaves");
    if (c != null) {
        c.removeAll();
    }
    slaveRepository.delete(id);

    return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("slave", id.toString())).build();
}