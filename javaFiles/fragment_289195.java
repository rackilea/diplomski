@PostMapping("/<postmapping-url-here>")
    public ResponseEntity<MyOwnDefinedEntity> getMyOwnDefinedEntity(@PathVariable Long id) {
        log.debug("REST request to get MyOwnDefinedEntity : {}", id);
        Optional<MyOwnDefinedEntity> myOwnDefinedEntity = myOwnDefinedEntityRepository.findById(id);
        //if(myOwnDefinedEntity.isPresent())
        return new ResponseEntity<MyOwnDefinedEntity>(MyOwnDefinedEntity.get(), HttpStatus.OK);
    }