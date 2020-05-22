public abstract class AbstractPerson implements Person {
    private String name;
    private String age; // maybe int ?
    private Gender gender;

    public  AbstractPerson() {

    }

    @override
    public void setName(String name) {
        this.name = name;
    }

    @override       
    public String getName() {
        return name;
    }

    @override       
    public void setAge(String age) {
        this.age = age;
    }

    @override
    public String getAge() {
        return age;
    }

    @override
    public Gender getGender() {
        return this.gender;
    }

    @override
    public void setGender(Gender gender) {
        this.gender = gender;
    }
}