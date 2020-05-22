package com.sandbox;

import com.google.common.base.Joiner;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SandboxTest {

    @Test
    public void testQuestionInput() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Foo", "scientist"));
        persons.add(new Person("Foo", "teacher"));
        persons.add(new Person("Bar", "student"));
        String outputString = getOutputString(persons);
        assertEquals("Foo, scientist, teacher\n" +
                "Bar, student\n", outputString);
    }

    private String getOutputString(List<Person> in) {

        Multimap<String, String> map = LinkedListMultimap.create();
        for (Person person : in) {
            map.put(person.name, person.occupation);
        }

        StringBuilder buf = new StringBuilder();
        Joiner joiner = Joiner.on(", ");
        for (String key : map.keySet()) {
            buf.append(key).append(", ").append(joiner.join(map.get(key))).append("\n");
        }
        return buf.toString();
    }

    class Person {

        Person(String name, String occupation) {
            this.name = name;
            this.occupation = occupation;
        }

        private String name;
        private String occupation;
    /* Getters and setters*/
    /* toString method */
    }

}