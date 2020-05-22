import static org.junit.Assert.*;
import org.junit.Test;

public class CustomClass {

    String firstName;
    String lastName;

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Test
    public void testEqaulity() {
        CustomClass clazz1 = new CustomClass();
        clazz1.setFirstName("Stack");
        clazz1.setLastName("Overflow");

        CustomClass clazz2 = new CustomClass();
        clazz2.setFirstName("Stack");
        clazz2.setLastName("Overflow");

        assertEquals(clazz1, clazz2);
    }

    /*
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result
                + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomClass other = (CustomClass) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        return true;
    }
    */
}