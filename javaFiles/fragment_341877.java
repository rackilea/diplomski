class Person {

    private String name;
    private int age;

    // Constructor uses setters to perform validation.
    // Throws IllegalArgumentException on invalid parameter.
    public Person (String name, int age) {
        setName(name);
        setAge(age);
    }

    // Setter validates name.
    public final void setName (String name) {
        if (name == null)
            throw new IllegalArgumentException("Invalid name specified.");
        this.name = name;
    }

    // Setter validates age.
    public final void setAge (int age) {
        if (age <= 0 || age > 150)
            throw new IllegalArgumentException("Invalid age specified."); 
        this.age = age;
    }

    // Guaranteed to return a non-null name.
    public final String getName () {
        return this.name;
    }

    // Guaranteed to return an age > 0 and <= 150.
    public final int getAge () {
        return this.age;
    }

}