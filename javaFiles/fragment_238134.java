@RequestMapping(value = "/get-templates", method = RequestMethod.GET)
public List<Template> getTemplates(@RequestParam(required = false, name = "context") String context) {
   ObjectMapper mapper = new ObjectMapper();
   Context myContext = mapper.readValue(context, Context.class); 
   //...
}