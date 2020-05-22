@RequestMapping(value="/{endPoint}", method=RequestMethod.POST)
public String endPoint(@PathVariable String endPoint) {
   //Your endPoint is now the one what the user would like to reach
   //So you check if your property file contains this String - better to cache it's content
   //If it does, you call the service with the regarding Stored Procedure.
   String sPName = prop.getSPName(endPoint); //You need to implement it.
   String answer = yourService.execute(sPName);
   return answer; 
 }