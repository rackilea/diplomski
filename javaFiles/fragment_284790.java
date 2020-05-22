@Controller
@RequestMapping("employer")
public class EmployerController {

    // Manage dynamically added or removed employees
    private List<Employee> manageEmployees(Employer employer) {
        // Store the employees which shouldn't be persisted
        List<Employee> employees2remove = new ArrayList<Employee>();
        if (employer.getEmployees() != null) {
            for (Iterator<Employee> i = employer.getEmployees().iterator(); i.hasNext();) {
                Employee employee = i.next();
                // If the remove flag is true, remove the employee from the list
                if (employee.getRemove() == 1) {
                    employees2remove.add(employee);
                    i.remove();
                // Otherwise, perform the links
                } else {
                    employee.setEmployer(employer);
                }
            }
        }
        return employees2remove;
    }

    // -- Creating a new employer ----------

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(@ModelAttribute Employer employer, Model model) {
        // Should init the AutoPopulatingList
        return create(employer, model, true);
    }

    private String create(Employer employer, Model model, boolean init) {
        if (init) {
            // Init the AutoPopulatingList
            employer.setEmployees(new AutoPopulatingList<Employee>(Employee.class));
        }
        model.addAttribute("type", "create");
        return "employer/edit";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute Employer employer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Should not re-init the AutoPopulatingList
            return create(employer, model, false);
        }
        // Call the private method
        manageEmployees(employer);
        // Persist the employer
        employerService.save(employer);
        return "redirect:employer/show/" + employer.getId();
    }

    // -- Updating an existing employer ----------

    @RequestMapping(value = "update/{pk}", method = RequestMethod.GET)
    public String update(@PathVariable Integer pk, @ModelAttribute Employer employer, Model model) {
        // Add your own getEmployerById(pk)
        model.addAttribute("type", "update");
        return "employer/edit";
    }

    @RequestMapping(value = "update/{pk}", method = RequestMethod.POST)
    public String update(@PathVariable Integer pk, @Valid @ModelAttribute Employer employer, BindingResult bindingResult, Model model) {
        // Add your own getEmployerById(pk)
        if (bindingResult.hasErrors()) {
            return update(pk, employer, model);
        }
        List<Employee> employees2remove = manageEmployees(employer);
        // First, save the employer
        employerService.update(employer);
        // Then, delete the previously linked employees which should be now removed
        for (Employee employee : employees2remove) {
            if (employee.getId() != null) {
                employeeService.delete(employee);
            }
        }
        return "redirect:employer/show/" + employer.getId();
    }

    // -- Show an existing employer ----------

    @RequestMapping(value = "show/{pk}", method = RequestMethod.GET)
    public String show(@PathVariable Integer pk, @ModelAttribute Employer employer) {
        // Add your own getEmployerById(pk)
        return "employer/show";
    }

}