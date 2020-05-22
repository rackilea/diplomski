class Employee {
    public static final int size = 0;
    String firstName;
    String surname;
    int yearOfBirth;
    String PPSNumber;
    String email;
    String phoneNumber;

    public Employee(String firstName, String surname, int yearOfBirth, String PPSNumber, String email, String phoneNumber) {
        this.firstName = firstName;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.PPSNumber = PPSNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (yearOfBirth != employee.yearOfBirth) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (surname != null ? !surname.equals(employee.surname) : employee.surname != null) return false;
        if (PPSNumber != null ? !PPSNumber.equals(employee.PPSNumber) : employee.PPSNumber != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        return phoneNumber != null ? phoneNumber.equals(employee.phoneNumber) : employee.phoneNumber == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + yearOfBirth;
        result = 31 * result + (PPSNumber != null ? PPSNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }
}