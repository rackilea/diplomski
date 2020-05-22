public class Vehicle {
    private String registrationNumber;        
    public Vehicle(String rego) {
       registrationNumber = rego;
    }        
    public String getRegistrationNumber() {
       return registrationNumber;
    }
    public String toString() {
       return registrationNumber;
    }
}