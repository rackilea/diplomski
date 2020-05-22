@GetMapping(path= "/getById/{company_id}")
String getById(@RequestBody KeyEntity keyEntity, @PathVariable int company_id){
String encKey= null;
KeyEntity key = gkrepo.findById(company_id).get();
encKey= key.getKeyencrypted();
return encKey;