/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sl4jdemo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class arrayTest {

    public static class Person{
        String name;
        String SSL;
        String Street;
        Integer age;

        public String getSSL() {
            return SSL;
        }

        public void setSSL(String SSL) {
            this.SSL = SSL;
        }

        public String getStreet() {
            return Street;
        }

        public void setStreet(String Street) {
            this.Street = Street;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Person(String name, String SSL, String Street, Integer age) {
            this.name = name;
            this.SSL = SSL;
            this.Street = Street;
            this.age = age;
        }

    }
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<arrayTest.Person>();
        persons.add(new Person("Bob", "FKJHHS87546", "WALLSTREET", 21));
        persons.add(new Person("Tom", "SEFSDF875463", "WALLSTREET", 25));
        for (Person person : persons) {
            System.out.println("Name : "+person.getName());
            System.out.println("SSL : "+person.getSSL());
            System.out.println("Street : "+person.getStreet());
            System.out.println("Age : "+person.getAge());
        }
    }
}