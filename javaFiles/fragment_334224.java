@GetMapping("/")
public ModelAndView queryEmployeeExample(EmployeeQueryDTO query) {
    Page response = this.employeeRepository.findAll((root, 
                                                    criteriaQuery, 
                                                    criteriaBuilder) -> {

    ArrayList<Predicate> predicates = new ArrayList<>();

    if(query.getId() != null) {
        predicates.add(
            criteriaBuilder.equal(
                    root.get("id"), 
                    query.getId()
            )
        );
    }
    if(query.getSalary() != null) {
        //Downcast Root object to the specified type.
        Root<FullTimeEmployee> rootFullTImeEmployee = criteriaBuilder
                                        .treat(root, FullTimeEmployee.class);
        predicates.add(
            criteriaBuilder.equal(
                    rootFullTImeEmployee.get("salary"), 
                    query.getSalary()
            )
        );
    }
    if(query.getHourlyWage() != null) {
        //Downcast Root object to the specified type.
        Root<PartTimeEmployee> rootPartTimeEmployee = criteriaBuilder
                                        .treat(root, PartTimeEmployee.class);
        predicates.add(
            criteriaBuilder.equal(
                    rootPartTimeEmployee.get("hourlyWage"), 
                    query.getHourlyWage()
            )
        );
    }
    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));}, 
                new PageRequest(0, 100));

    return new ModelAndView("index")
                .addObject("result", response);
}

@Getter
@Setter
static class EmployeeQueryDTO {
    private Long id;
    private Integer salary;
    private Float hourlyWage;
}