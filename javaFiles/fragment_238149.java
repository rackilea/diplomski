@RequestMapping(value = "/employees", produces = 
MediaType.APPLICATION_XML_VALUE, method = RequestMethod.GET)
public String getAllEmployeesXML(Model model) 
{
model.addAttribute("employees", getEmployeesCollection());
return "xmlTemplate";
}