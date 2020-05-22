@RequestMapping(value = "/register", method = RequestMethod.POST)
public String postUser(@Valid @ModelAttribute("employeeForm") Employee employee, BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "addEmployee";
    } else {
        employeeService.addEmployee(employee);
        model.addObject("employees", employeeService.getEmployees());
        return "displayEmployee";
    }
}