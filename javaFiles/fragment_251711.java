class GfG {
    public static void main(String[] args) {

        Staffmember aStaffMember = new Staffmember("Steven", "bob");
        System.out.println(aStaffMember.toString());

        Programmer appleprg = new Programmer("Marion", "bob", "Java");
        appleprg.getLanguage();
        System.out.println(appleprg.toString());

        Doctor dr = new Doctor();
        dr.setWard(5);
        dr.setFirstName("ed");
        dr.setLastName("fall");

        System.out.println(dr.toString());

    }
}

class Staffmember {
    String firstName;
    String lastname;

    public Staffmember(String firstName, String lastname) {
        super();
        this.firstName = firstName;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Staff Member firstName=" + firstName + ", lastname=" + lastname;
    }

}

class Programmer {
    String firstName;
    String lastName;
    String Language;

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Programmer(String firstName, String lastname, String Language) {
        super();
        this.firstName = firstName;
        this.lastName = lastname;
        this.Language = Language;
    }

    @Override
    public String toString() {
        return "Programmer firstName=" + firstName + ", lastName=" + lastName + ", Language=" + Language;
    }

}

class Doctor {
    int ward;
    String firstName;
    String lastName;

    public void setWard(int ward) {
        this.ward = ward;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public Doctor(int ward, String firstName, String lastName) {
        super();
        this.ward = ward;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Doctor ward=" + ward + ", firstName=" + firstName + ", lastName=" + lastName;
    }

}