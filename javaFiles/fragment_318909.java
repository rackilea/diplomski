public class Person{

    String address;
    int mobileNumber;
    String officeId;
     // many fields like this (atleast 15 fields)

    private Person oldValues;

    public Person(String address, int mobileNumber, String officeId) {
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.officeId = officeId;
        oldValues = new Person(this);
    }

    public Person(Person p) {
        this.address = p.address;
        this.mobileNumber = p.mobileNumber;
        this.officeId = p.officeId;
    }

    // Your method that checks if any value did change.
    public void checkIfValuesChanged() {
        if(this.equals(oldValues)) {
            // Nothing changed
        }
    }

     @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + mobileNumber;
        result = prime * result + ((officeId == null) ? 0 : officeId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if(!(obj instanceof Person)) return false;
        Person other = (Person) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (mobileNumber != other.mobileNumber)
            return false;
        if (officeId == null) {
            if (other.officeId != null)
                return false;
        } else if (!officeId.equals(other.officeId))
            return false;
        return true;
    }

    // Your setter methods do save the old values in the oldValues Person object
    public void setAddress(String address) {
        oldValues.address = this.address;
        this.address = address;
    }

}