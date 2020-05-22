@RequestMapping(method = RequestMethod.GET)
public ResponseEntity<Status> getStatus() throws IOException {
    Status status = new Status();
    status.isAppAlive = statusService.isAppAlive();
    status.isDbAlive = statusService.isDbAlive();
    return new ResponseEntity<Status>(status, HttpStatus.OK);
}