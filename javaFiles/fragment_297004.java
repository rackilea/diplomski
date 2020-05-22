package net.IndyStef;

import net.IndyStef.model.Person;
import net.IndyStef.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MongoDbTestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbTestApplication.class, args);
    }

    @Autowired
    private PersonRepository repository;

    @Override
    public void run(String... args) {

        repository.save(new Person("peter.pan", "Peter Pan", 865));

        List<Person> people = repository.findAll();

        for (Person person: people) {
            System.out.println(person);
        }
    }
}