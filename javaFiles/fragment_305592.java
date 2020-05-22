public ResponseEntity insertFlow(@RequestBody Flow flow) {
    final Flow saved = flowRepository.save(flow);
    if (saved != null) {
        logger.info("Flow saved");
    }
    // ...
}