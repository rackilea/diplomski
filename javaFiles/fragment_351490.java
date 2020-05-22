@RequestMapping(value = "/deletePart.htm", method = RequestMethod.GET)
public String deletePart(String part_id) {
   LOG.debug("in deletePart, part_id: "+part_id);
   GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("mongodb.xml");
   try {
      MongoOperations mongoOps = (MongoOperations)ctx.getBean("mongoTemplate");
      Part p = mongoOps.findOne(new Query(where("id").is(part_id)), Part.class);
      mongoOps.remove(p);     
      return "redirect:/parts.htm";
   } finally {
      ctx.close();   // close the context, will close the Mongo instance
   }
}