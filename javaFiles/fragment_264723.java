public class Person {
    private Long id;

    public boolean equals(Object object) {
        return (object instanceof Person) && (id != null) 
             ? id.equals(((Person) object).id) 
             : (object == this);
    }
}