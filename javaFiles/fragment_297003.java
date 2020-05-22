package net.IndyStef.repository;

import net.okrongli.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by IndyStef on 23/08/16.
 */
public interface PersonRepository extends MongoRepository<Person, String> {
}