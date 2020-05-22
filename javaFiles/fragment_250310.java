...
private int age
private Date dob

...
public void setDateOfBirth(Date dob)
{
    this.dob = dob;
    age = ... //some logic to calculate the age from the Date of Birth.
}