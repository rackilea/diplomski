package com.technoroy.examples.guava;

/**
 * A value holder POJO implementation for Employee records
 * @author Rahul R
 *
 */
class Employee {
    private Integer id = null;
    private String name = null;

    public Employee() {
        super();
    }

    public Employee(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }
}