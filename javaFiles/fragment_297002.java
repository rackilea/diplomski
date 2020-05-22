package net.IndyStef.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person")
public class Person {

@Id
private String id;

private String name;
private Integer age;

public Person() {
}

public Person(String id) {
    this.id = id;
}

public Person(String id, String name, Integer age) {
    this.id = id;
    this.name = name;
    this.age = age;
}

... getters/setters omitted for breverity ...
}