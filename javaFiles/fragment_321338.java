package com.example.accounting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Company {
// Object fields
LinkedList<Department> departments = null;

public Company() {
    departments = new LinkedList<Department>();
}

public boolean addDepartment(String file) {
    Scanner source = null;

    try {
        source = new Scanner(new FileReader(file));
    } catch (FileNotFoundException e) {
        System.out.println("Error trying to read " + file + ": " + e.getMessage());
        e.printStackTrace();
        return false;
    }
    source.useDelimiter(";");

    while(source.hasNextLine()) {
        int departmentId = source.nextInt();
        String departmentName = source.next();
        String departmentLocation = source.next();
        departments.add(new Department(departmentId, departmentName, departmentLocation));
    }
    source.close();
    return true;
}

public LinkedList<Department> getDepartments() {
    return departments;
}

public void listDepartments() {

    for (Department dept : departments) {
        System.out.println(" " + dept.getDeptId() + ". " + dept.getDeptName() + ", " + dept.getDeptLoc());
    }
}
}