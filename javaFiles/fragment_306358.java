public static Parent createFromPerson(Person person) {
    Parent p = new Parent();
    // Assuming fields are protected
    this.prop = person.prop;
    this.anotherProp = person.prop;
    return p;
}