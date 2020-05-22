@GET
 @Path("/hello/{personCode}")
 @Produces("application/xml") //added this line ,you can declare anything json/xml
 public Personel getPersonelByPersonCode(@PathParam("personCode") String personCode) {
     Personel personel = new Personel(personCode);
     return personel;
 }