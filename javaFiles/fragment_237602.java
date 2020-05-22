@XmlElements({
    @XmlElement(name="director", type=Employee.class),
    @XmlElement(name="manager", type=Employee.class)
})
List<Employee> getEmployees() {
    return employees;
}