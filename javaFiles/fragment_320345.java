package com.test;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SpringBootApplication
public class TestDataRestApplication {

    @Autowired
    private PersonRepository repo;

    @PostConstruct
    public void inti () {
        System.out.println("************** running init");

        repo.save(new Person("Batman"));
    }

    public static void main(String[] args) {
        SpringApplication.run(TestDataRestApplication.class, args);
    }
}

@RepositoryRestResource(path="person")
interface PersonRepository extends JpaRepository<Person, Long> {

}

@Entity
class Person {
    @Id
    private long id;

    private String name;

    public Person() {

    }

    public Person(String name) {
        super();
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}