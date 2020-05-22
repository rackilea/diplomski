package com.example.accounting;
import java.util.LinkedList;
public class Main {
// Object fields
private static Main me;
private Company company;
private LinkedList<Department> departments;

/**
 * @param args
 */
public static void main(String[] args) {
    // TODO Auto-generated method stub
    me = new Main();
    me.doWork(args);

}

private void doWork(String[] args) {
    //TODO accept file name as an argument?!

    company = new Company();
    company.addDepartment("Department.in");
    company.listDepartments();

    departments = company.getDepartments();
}
}