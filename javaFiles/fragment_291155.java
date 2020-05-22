@GetMapping(value = "userRight/hasRightForOperation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<?> hasRightForOperation(@RequestParam("loginName") String loginName,
                                              @RequestParam("vendorId") String vendorId,
                                              @RequestParam("accessRightCode") String accessRightCode) {
    return new ResponseEntity<>(hasRightForOperation(loginName, vendorId, accessRightCode), HttpStatus.OK);
}