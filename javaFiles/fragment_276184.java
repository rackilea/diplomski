@RequestMapping(value = "/wells/{apiValue}", method = RequestMethod.GET)
public ResponseEntity<?> fetchWellData(@PathVariable String apiValue){
    try{
        OngardWell ongardWell = new OngardWell();
        ongardWell = ongardWellService.fetchOneByApi(apiValue);

        return new ResponseEntity<>(ongardWell, HttpStatus.OK);
    }catch(Exception ex){
        String errorMessage;
        errorMessage = ex + " <== error";
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}