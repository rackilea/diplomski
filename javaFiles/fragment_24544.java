@GetMapping(path = "/", produces = MediaType.TEXT_HTML_VALUE)
public String html(Model model) { // <== changed return type, added parameter
    Employee employee = Employee.builder()
        .name("test")
        .build();
    model.addAttribute("employee", employee);
    return "employeedetail"; // view name, aka template base name
}