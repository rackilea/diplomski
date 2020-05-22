public class Person {
    private String commonName;
    private String userNameGenerator;

    ...

    @Override
    public int hashCode() 
    {
        return userNameGenerator.hashCode();
    }

    @Override
    public boolean equals(Object o) 
    {
        if (this == o) return true;

        if (this.getClass() != o.getClass()) return false;

        final Person that = (Person) o;

        return this.userNameGenerator.equals(that.userNameGenerator);
    } 
}