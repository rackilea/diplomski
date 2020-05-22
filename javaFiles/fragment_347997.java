/*
 * Is something like this possible with JPA?
 */
if (departmentId == null) {
    @JoinColumn(name = "projectCode", referencedColumnName = "assignedProject")
} else {
    @JoinColumn(name = "departmentId", referencedColumnName = "id")
}