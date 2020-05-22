public class Person implements Comparable<Person> {
    public String Name;
    public String Ni;
    public String Dob;

    public Person(String name, String ni, String dob){
        this.Name = name;
        this.Ni = ni;
        this.Dob = dob;
    }

    @Override
    public int compareTo(Person person) {
        return Dob.compareTo(person.getDob()); // you really want to compare by who is younger here right? whatever it is, put it here instead of String compare
    }

    public String getDob() {
        return Dob;
    }

    public String toString()
    {
        return this.Name + " " + this.Ni + " " + this.Dob;
    }
}