@org.junit.Test
public void method() throws Exception {
    Iterable<Person> people = Arrays.asList(new Person(), new Person());
    Assert.assertThat(people, (Every.everyItem(HasPropertyWithValue.hasProperty("gender", Is.is("male")))));
}

public static class Person {
    String gender = "male";

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}