package controllers;

public class Database {
    private static Database instance = new Database();

    public static Database getInstance() {
        return instance;
    }

    public void savePerson(String department, String firstName, String lastName) {
        System.out.println("Saved person " + firstName + " " + lastName + " into department " + department);
    }

    public void saveGroup(String department, String groupName, String description) {
        System.out.println("Saved group " + groupName + " with description " + description + " into department " + department);
    }
}