private class MyController{

     @Autowire
     ProcessAction object;

     @RequestMapping(value = "/worker", method = RequestMethod.POST)
     public ResponseEntity<?> addWorkerInDatabase(HttpServletRequest request,
             @RequestParam(value = "json", defaultValue = 
    "{\"dni\":\"00000000A\",\"nombre\":\"Paco\",\"apellido1\":\"Ruiz\",\"apellido2\":\"Díaz\"}") final String json){
         return object.createResponse(request, json);
 }