Employee findByEmail(String email) {
    for (Employee employee : yourMap.values())
        if (employee.getEmail().equals(email))
            return employee;

    // Not found.
    return null;
}