package de.scrum_master.aop.app;

public class Application {
    private int id;
    @ValidateName
    private String firstName;
    @ValidateName
    private String lastName;
    private String placeOfBirth;

    public Application(int id, String firstName, String lastName, String placeOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.placeOfBirth = placeOfBirth;
    }

    @Override
    public String toString() {
        return "Application [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", placeOfBirth=" + placeOfBirth
                + "]";
    }

    public static void main(String[] args) {
        System.out.println(new Application(1, "Galileo", "Galilei", "Pisa, Italy"));
        System.out.println(new Application(2, "Isaac", "Newton", "Woolsthorpe-by-Colsterworth, United Kingdom"));
        System.out.println(new Application(3, "Albert", "Einstein", "Ulm, Germany"));
        System.out.println(new Application(4, "Werner", "Heisenberg", "Würzburg, Germany"));
    }
}