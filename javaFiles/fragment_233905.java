public class Class1 {

    private String firstName;
    private String middleName;
    private String lastName;

    /*
     * Setters
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /*
     * Getters
     */

    public String getMiddleName() {
        return middleName;
    }

    /*
     * toString
     */

    public String toString() {
        if(firstName == "" && middleName == "" && lastName == "") {
            return "";
        } else if (firstName == null && middleName == null && lastName == null) {
            return null;
        } else
        return firstName + " \"" + middleName + "\" " + lastName;
    }
}