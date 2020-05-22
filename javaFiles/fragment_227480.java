@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
public String saveEmployee(@ModelAttribute("employee") Employee employee){
    int id = 1; // 2 or 3...

    Department temporaryDepartment = new Department();
    temporaryDepartment.setId(id);

    employee.setDepartment(temporaryDepartment); 
    employeeService.saveEmployee(employee);
    return "redirect:/employees";
}