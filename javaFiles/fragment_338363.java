@Entity
public class Person {
    int age;
    String ageCategory;

    /**
     * Simple setting of ageCategory.
     */
    @PostLoad
    public void postLoadPerson {
        if(age < 10) {
            setAgeCategory("A");
        } else if (age < 30) {
            setAgeCategory("B");
        } else {
            setAgeCategory("C");
        }
    }
}