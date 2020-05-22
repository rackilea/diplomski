import java.text.DateFormat;
import java.util.Date;

public class Person
{
    private String name;
    private Date birthdate;
    private Gender gender;
    private MaritalStatus maritalStatus;

    public Person(String name)
    {
        this(name, new Date(), Gender.MALE, MaritalStatus.SINGLE);
    }

    public Person(String name, Gender gender)
    {
        this(name, new Date(), gender, MaritalStatus.SINGLE);
    }

    public Person(String name, Date birthdate)
    {
        this(name, birthdate, Gender.MALE, MaritalStatus.SINGLE);
    }

    public Person(String name, Date birthdate, Gender gender)
    {
        this(name, birthdate, gender, MaritalStatus.SINGLE);
    }

    public Person(String name, Date birthdate, Gender gender, MaritalStatus maritalStatus)
    {
        if ((name == null) || (name.trim().length() == 0))
            throw new IllegalArgumentException("name cannot be blank or null");

        this.name = name;
        this.birthdate = ((birthdate == null) ? new Date() : new Date(birthdate.getTime()));
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName()
    {
        return name;
    }

    public Date getBirthdate()
    {
        return new Date(birthdate.getTime());
    }

    public Gender getGender()
    {
        return gender;
    }

    public MaritalStatus getMaritalStatus()
    {
        return maritalStatus;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Person person = (Person) o;

        if (!birthdate.equals(person.birthdate))
        {
            return false;
        }
        if (gender != person.gender)
        {
            return false;
        }
        if (maritalStatus != person.maritalStatus)
        {
            return false;
        }
        if (!name.equals(person.name))
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = name.hashCode();
        result = 31 * result + birthdate.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + maritalStatus.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        return "Person{" +
               "name='" + name + '\'' +
               ", birthdate=" + DateFormat.getDateInstance(DateFormat.MEDIUM).format(birthdate) +
               ", gender=" + gender +
               ", maritalStatus=" + maritalStatus +
               '}';
    }
}