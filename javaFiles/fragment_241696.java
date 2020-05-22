@RequestMapping(value = "/getSomething"
        , method = RequestMethod.POST
        , consumes = "application/json"
        , produces = "application/json")
@ResponseBody
public ResponseEntity<?> getSomething(@RequestBody Input f) {

    DAOImpl dAOImpl = (MapDAOImpl) appContext.getBean("DAOImpl");

    Boolean res =  dAOImpl.validateToken(f.session);
    if(res) {
        List<Obj> response = dAOImpl.getSomething(f.ID);
        return new ResponseEntity<>(response, HttpStatus.OK);
    } 
    return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
}