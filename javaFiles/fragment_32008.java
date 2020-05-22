public abstract class Person {

    protected String name, fname;

    public Person (String name, String fname) {
        this.name = name;
        this.fname = fname;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public void setFname (String fname) {
        this.fname = fname;
    }

    public String getFname () {
        return fname;
    }

}