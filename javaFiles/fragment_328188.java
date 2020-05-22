package me.eckhart;

import java.util.List;

public abstract class Employee {

    private String name = null;
    public static final String OPERATION_NOT_SUPPORTED = "Operation not supported.";

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        if (name == null) throw new IllegalArgumentException("Argument 'name' is null.");
        this.name = name;
        return this;
    }

    public Employee addEmployee(Employee employee) {
        throw new UnsupportedOperationException(OPERATION_NOT_SUPPORTED);
    }

    public List<Employee> getEmployees() {
        throw new UnsupportedOperationException(OPERATION_NOT_SUPPORTED);
    }

    public Employee setEmployees(List<Employee> employees) {
        throw new UnsupportedOperationException(OPERATION_NOT_SUPPORTED);
    }

    public Employee setLanguagesList(List<ProgrammingLanguages> languagesList) {
        throw new UnsupportedOperationException(OPERATION_NOT_SUPPORTED);
    }

    public Employee addProgrammingLanguage(ProgrammingLanguages language) {
        throw new UnsupportedOperationException(OPERATION_NOT_SUPPORTED);
    }

    public List<ProgrammingLanguages> getLanguagesList() {
        throw new UnsupportedOperationException(OPERATION_NOT_SUPPORTED);
    }

    /* Composite operations. */

    public abstract int getWorkload(ProgrammingLanguages language);

    public abstract Employee setWorkload(int workload);

}