@RequestMapping(value = "/employees", produces = 
MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
public String getAllEmployeesJSON(Model model) 
{
model.addAttribute("employees", getEmployeesCollection());
return "jsonTemplate";
}