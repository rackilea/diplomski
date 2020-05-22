package de.scrum_master.app;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@AnnotateGetter({ Unique.class, SortOrder.class, CollationType.class })
public class Person {
    @Unique
    private final int id;

    @SortOrder("descending")
    @CollationType("alphabetical")
    private final String firstName;

    @SortOrder("random")
    @CollationType(value = "alphanumeric", language = "DE")
    private final String lastName;

    @SortOrder("ascending")
    @CollationType(value = "numeric")
    private final int fieldWithoutGetter;

    public Person(int id, String firstName, String lastName, int fieldWithoutGetter) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fieldWithoutGetter = fieldWithoutGetter;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public void doSomething() {}
    public void doSomethingElse() {}

    public static void main(String[] args) {
        System.out.println("Field annotations:");
        for (Field field : Person.class.getDeclaredFields()) {
            System.out.println("  " + field.getName());
            for (Annotation annotation : field.getAnnotations())
                System.out.println("    " + annotation);
        }
        System.out.println();
        System.out.println("Method annotations:");
        for (Method method : Person.class.getDeclaredMethods()) {
            System.out.println("  " + method.getName());
            for (Annotation annotation : method.getAnnotations())
                System.out.println("    " + annotation);
        }
    }
}