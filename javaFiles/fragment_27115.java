public class Person implements Identifiable<String> {

    private String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String t) {
        this.id = t;
    }

    public static void main(String[] args) {
        Person person = new Person();
        Method method = person.getClass().getMethods()[1]; //prints getId
        System.out.println(method.getName());
        System.out.println(method.getGenericReturnType());  //prints String
    }
}